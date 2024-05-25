package com.dongguk.csc40281.securezone.bouquet.controller;

import com.dongguk.csc40281.securezone.bouquet.dto.MemberDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String account(HttpSession session, RedirectAttributes redirect) {
        if (!isLoggedIn(session)) {
            redirect.addFlashAttribute("alertMessage", "로그인이 필요합니다.");
            return "redirect:/login";
        }
        return "account";
    }

    @GetMapping("/search")
    public String find() {
        return "search_result";
    }

    @GetMapping("/add")
    public String add(HttpSession session, RedirectAttributes redirect) {
        if (!isLoggedIn(session, "ADMIN")) {
            redirect.addFlashAttribute("alertMessage", "권한이 없습니다.");
            return "redirect:/login";
        }
        return "add_new_product";
    }

    @GetMapping("/customer/center")
    public String customerCenter() {
        return "customer_center";
    }

    @GetMapping("/withdrawal")
    public String withdrawal(HttpSession session, RedirectAttributes redirect) {
        if (!isLoggedIn(session)) {
            redirect.addFlashAttribute("alertMessage", "로그인이 필요합니다.");
            return "redirect:/login";
        }
        return "membership_withdrawal";
    }

    @GetMapping("/pay")
    public String pay(HttpSession session, RedirectAttributes redirect) {
        if (!isLoggedIn(session)) {
            redirect.addFlashAttribute("alertMessage", "로그인이 필요합니다.");
            return "redirect:/login";
        }
        return "pay";
    }

    @GetMapping("pay/result")
    public String payResult(HttpSession session, RedirectAttributes redirect) {
        if (!isLoggedIn(session)) {
            redirect.addFlashAttribute("alertMessage", "로그인이 필요합니다.");
            return "redirect:/login";
        }
        return "payment_result";
    }

    @GetMapping("/product")
    public String product() {
        return "product_list";
    }

    @GetMapping("/basket")
    public String basket(HttpSession session, RedirectAttributes redirect) {
        if (!isLoggedIn(session)) {
            redirect.addFlashAttribute("alertMessage", "로그인이 필요합니다.");
            return "redirect:/login";
        }
        return "shopping_basket";
    }

    private boolean isLoggedIn(HttpSession session) {
        return session != null && session.getAttribute("member") != null;
    }

    private boolean isLoggedIn(HttpSession session, String role) {
        if (session != null && session.getAttribute("member") != null) {
            MemberDto member = (MemberDto) session.getAttribute("member");
            return member.getRole().equals(role);
        }
        return false;
    }

}
