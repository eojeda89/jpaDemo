package com.example.jpademo.dtos;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private long id;
    private String fullName;
    private String email;
    private List<ProjectResponse> projects;
}
