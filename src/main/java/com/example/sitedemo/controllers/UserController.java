package com.example.sitedemo.controllers;

import com.example.sitedemo.models.User;
import com.example.sitedemo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @GetMapping("/hello")
    public String GetUrl(){
        return "hello";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model){
        if(userService.createUser(user) == false){
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует!");
            return "registration";
        }

        return "redirect:/login";
    }
}
