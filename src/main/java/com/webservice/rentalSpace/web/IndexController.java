package com.webservice.rentalSpace.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user/login")
    public String login_user() {
        return "login_user";
    }
}

