package com.example.restservice;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private Integer id;
    private String email;
    private String password;
    @Column(name = "fullname")
    private String fullName;

    public User(Integer id, String email, String password, String fullName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.fullName = userDto.getFullName();
    }

    public User() {

    }
}
