package com.supriya.UserManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class User {

    @NotEmpty
    @Pattern(regexp = "[0-9]+")
    private String userId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String userName;
    @Email
    @NotEmpty
    private String address;
    @Pattern(regexp = "[0-9]{10,12}")
    private String phone_number;

}
