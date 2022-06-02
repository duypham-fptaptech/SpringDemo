package com.example.springdemo.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {
    private String rollNumber;
    private String fullName;
    private String address;
    private LocalDateTime dob;
}
