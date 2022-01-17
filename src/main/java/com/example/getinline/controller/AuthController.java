package com.example.getinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: kbs
 */
@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("auth/sign-up")
    public String signUp(){
        return "sign-up";
    }

}

