package com.kaishengit.tsm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/")
    public String index(){

        return "index";
    }
}
