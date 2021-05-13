package com.example.restservice;

import lombok.Data;

@Data
public class UserPatchDto {
    private String email;
    private String password;
    private String fullName;

}
