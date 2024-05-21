package com.dongguk.csc40281.securezone.bouquet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/join")
    public String join() {
        return "join_membership";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
