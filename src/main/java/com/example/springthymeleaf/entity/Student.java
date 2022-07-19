package com.example.springthymeleaf.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private String rollNumber;
    private String fullName;
    private String email;
    private String phone;
    private int status;
}
