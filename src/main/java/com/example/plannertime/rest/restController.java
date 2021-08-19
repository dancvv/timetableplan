package com.example.plannertime.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("time")
public class restController {
    @GetMapping("/info")
    public String info(){
        return "info";
    }
}
