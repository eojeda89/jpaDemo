package com.example.jpademo.dtos;

import lombok.Data;

import java.util.List;

@Data
public class UserListResponse {
    List<UserResponse> users;
}
