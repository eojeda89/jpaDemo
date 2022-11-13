package com.example.jpademo.controllers;

import com.example.jpademo.auxiliaries.Utils;
import com.example.jpademo.dtos.ProjectResponse;
import com.example.jpademo.dtos.ResponseTemplate;
import com.example.jpademo.dtos.UserListResponse;
import com.example.jpademo.dtos.UserResponse;
import com.example.jpademo.entities.Project;
import com.example.jpademo.entities.User;
import com.example.jpademo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Utils utils;

    @GetMapping(produces = "application/json")
    public ResponseEntity<ResponseTemplate> getUsers(@RequestParam(required = false, defaultValue = "0") long id){
        try {
            List<User> userList;
            if (id > 0){
                userList = userService.findById(id);
            } else {
                userList = userService.findAllUsers();
            }
            if (userList.isEmpty()){
                return new ResponseEntity<>(new ResponseTemplate(HttpStatus.NOT_FOUND.value(), "User not found", null), HttpStatus.NOT_FOUND);
            }
            List<UserResponse> userListResponses = new ArrayList<>();
            for (User user : userList){
                UserResponse response = new UserResponse();
                response.setId(user.getId());
                response.setEmail(user.getEmail());
                response.setFullName(user.getFullName());
                List<ProjectResponse> projectResponses = new ArrayList<>();
                for (Project project : user.getProjects()){
                    ProjectResponse projectResponse = new ProjectResponse(project.getId(), project.getName(), project.getDescription(), project.getType());
                    projectResponses.add(projectResponse);
                }
                response.setProjects(projectResponses);
                userListResponses.add(response);
            }
            UserListResponse response = new UserListResponse();
            response.setUsers(userListResponses);
            return new ResponseEntity<>(new ResponseTemplate(HttpStatus.OK.value(), "Success", userListResponses), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseTemplate(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error: " + e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
