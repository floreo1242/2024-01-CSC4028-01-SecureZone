package com.dongguk.csc40281.securezone.bouquet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "main";
    }

    @GetMapping("/join")
    public String join() {
        return "join_membership";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/account")
    public String account() {
        return "account";
    }

    @GetMapping("/search")
    public String find() {
        return "search_result";
    }

    @GetMapping("/add")
    public String add() {
        return "add_new_product";
    }

    @GetMapping("/customer/center")
    public String customerCenter() {
        return "customer_center";
    }

    @GetMapping("/withdrawal")
    public String withdrawal() {
        return "membership_withdrawal";
    }

    @GetMapping("/pay")
    public String pay() {
        return "pay";
    }

    @GetMapping("pay/result")
    public String payResult() {
        return "payment_result";
    }

    @GetMapping("/product")
    public String product() {
        return "product_list";
    }

    @GetMapping("/basket")
    public String basket() {
        return "shopping_basket";
    }

}
