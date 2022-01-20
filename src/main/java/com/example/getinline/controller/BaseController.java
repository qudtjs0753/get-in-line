package com.example.getinline.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: kbs
 */
//BaseController가 담겨있는 패키지가 범위가 됨.
@ControllerAdvice(basePackageClasses = BaseController.class)
@Controller
//Error page를 따로 만들어서 돌리겠다고 명시해주는 것.
public class BaseController implements ErrorController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

}
