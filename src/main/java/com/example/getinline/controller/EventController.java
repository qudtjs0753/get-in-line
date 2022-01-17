package com.example.getinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: kbs
 */

@RequestMapping("/events")
@Controller
public class EventController {

    @GetMapping("/")
    public String events(){
        return "event/index";
    }

    @GetMapping("/{eventId}")
    public String events(@PathVariable Integer eventId){
        return "event/detail";
    }
}
