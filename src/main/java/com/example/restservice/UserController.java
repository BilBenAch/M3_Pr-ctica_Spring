package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class UserController {


    UserDAO userRepository;

    @Autowired
    public UserController(UserDAO userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> readAll() {

        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());


    }

    public UserDto getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) return new UserDto(user.get());
        else return null;
    }

    public UserDto addUser(UserDto userDto) {
        User user = new User(userDto);
        userRepository.save(user);

        return userDto;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }

    public UserDto updateOrNew(UserDto userDto, Integer id) {
        User user = new User(userDto);
        return userRepository.findById(id).map(o -> {
            o.setEmail(user.getEmail());
            o.setPassword(user.getPassword());
            o.setFullName(user.getFullName());
            userRepository.save(o);
            return new UserDto(o);
        }).orElseGet(() -> {
            UserDto userDto1 = new UserDto(userRepository.save(user));
            return userDto1;
        });

    }

    public UserDto updateEmail(UserPatchDto userPatchDto, Integer id) {
        return userRepository.findById(id).map(o -> {
            o.setEmail(userPatchDto.getEmail());
            userRepository.save(o);
            return new UserDto(o);
        }).orElse(null);

    }
}
