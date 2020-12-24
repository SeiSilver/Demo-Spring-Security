package com.sei.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/detail")
    public String showHome() {
        return "detail";
    }

    @GetMapping("/")
    public String showDetail() {
        return "home";
    }

    @GetMapping("/leader")
    public String showLeader() {
        return "leader";
    }

    @GetMapping("/system")
    public String showSystem() {
        return "system";
    }

}
