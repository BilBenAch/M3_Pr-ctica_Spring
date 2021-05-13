package com.example.restservice;

import lombok.Data;


@Data
public class UserDto {
    private Integer id;
    private String email;
    private String password;
    private String fullName;

    public UserDto(Integer id, String email, String password, String fullName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.fullName = user.getFullName();
    }


    public UserDto() {

    }
}
