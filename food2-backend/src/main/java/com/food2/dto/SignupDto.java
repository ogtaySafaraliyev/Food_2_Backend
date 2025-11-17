package com.food2.dto;

import lombok.Data;

@Data
public class SignupDto {
    private String email;
    private String password;
    private String companyName;
    private String address;
    private String contactInfo;
    // getters / setters
}

