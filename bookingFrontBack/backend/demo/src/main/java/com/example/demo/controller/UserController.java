package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }
    @GetMapping("/id/{id}")
    public User getByIdUser(@PathVariable("id") Long id){
        return userService.findByIdUser(id);
    }
}
