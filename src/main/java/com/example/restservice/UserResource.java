package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {
    public static final String USERS ="/users";

    UserController userController;

    @Autowired
    public UserResource(UserController userController) {
        this.userController = userController;
    }

    @GetMapping
    private List<UserDto> users() {
        return userController.readAll();
    }
    @GetMapping("/{id}")
    private UserDto user(@PathVariable Integer id){
        return userController.getUserById(id);

    }

    @GetMapping("/{id}/email")
    private Map<String, String> email(@PathVariable Integer id){
        return Collections.singletonMap("email",userController.getUserById(id).getEmail());

    }

    @PostMapping
    private UserDto addUser(@RequestBody UserDto user){
        return userController.addUser(user);
    }

    @DeleteMapping("/{id}")
    private void deleteUser(@PathVariable Integer id){
        userController.deleteUser(id);
    }
    @PutMapping("/{id}")
    private UserDto replaceUser(@RequestBody UserDto userDto, @PathVariable Integer id){
        return userController.updateOrNew(userDto, id);

    }
    @PatchMapping("/{id}")
    private UserDto replaceUserEmail(@RequestBody UserPatchDto userPatchDto, @PathVariable Integer id){
        return userController.updateEmail(userPatchDto, id);

    }


}
