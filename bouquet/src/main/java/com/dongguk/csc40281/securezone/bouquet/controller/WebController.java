package com.dongguk.csc40281.securezone.bouquet.controller;

import com.dongguk.csc40281.securezone.bouquet.dto.MemberDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        model.addAttribute("member", session.getAttribute("member"));
        return "main";
    }

    @GetMapping("/join")
    public String join(HttpSession session, Model model) {
        model.addAttribute("member", session.getAttribute("member"));
        return "join_membership";
    }

    @GetMapping("/login")
    public String login(HttpSession session, RedirectAttributes redirect, Model model) {
        if (isLoggedIn(session)) {
            redirect.addFlashAttribute("alertMessage", "이미 로그인 되어있습니다.");
            return "redirect:/";
        }
        model.addAttribute("member", session.getAttribute("member"));
        return "login";
    }

    @GetMapping("/account")
    public String account(HttpSession session, RedirectAttributes redirect, Model model) {
        if (!isLoggedIn(session)) {
            redirect.addFlashAttribute("alertMessage", "로그인이 필요합니다.");
            return "redirect:/login";
        }
        model.addAttribute("member", session.getAttribute("member"));
        return "account";
    }

    @GetMapping("/search")
    public String find(HttpSession session, Model model) {
        model.addAttribute("member", session.getAttribute("member"));
        return "search_result";
    }

    @GetMapping("/add")
    public String add(HttpSession session, RedirectAttributes redirect, Model model) {
        if (!isLoggedIn(session, "ADMIN")) {
            redirect.addFlashAttribute("alertMessage", "권한이 없습니다.");
            return "redirect:/login";
        }
        model.addAttribute("member", session.getAttribute("member"));
        return "add_new_product";
    }

    @GetMapping("/customer_center")
    public String customerCenter(HttpSession session, Model model) {
        model.addAttribute("member", session.getAttribute("member"));
        return "customer_center";
    }

    @GetMapping("/withdrawal")
    public String withdrawal(HttpSession session, RedirectAttributes redirect, Model model) {
        if (!isLoggedIn(session)) {
            redirect.addFlashAttribute("alertMessage", "로그인이 필요합니다.");
            return "redirect:/login";
        }
        model.addAttribute("member", session.getAttribute("member"));
        return "membership_withdrawal";
    }

    @GetMapping("/pay")
    public String pay(HttpSession session, RedirectAttributes redirect, Model model) {
        if (!isLoggedIn(session)) {
            redirect.addFlashAttribute("alertMessage", "로그인이 필요합니다.");
            return "redirect:/login";
        }
        model.addAttribute("member", session.getAttribute("member"));
        return "pay";
    }

    @GetMapping("pay/result")
    public String payResult(HttpSession session, RedirectAttributes redirect, Model model) {
        if (!isLoggedIn(session)) {
            redirect.addFlashAttribute("alertMessage", "로그인이 필요합니다.");
            return "redirect:/login";
        }
        model.addAttribute("member", session.getAttribute("member"));
        return "payment_result";
    }

    @GetMapping("/product")
    public String product(HttpSession session, Model model) {
        model.addAttribute("member", session.getAttribute("member"));
        return "product_list";
    }

    @GetMapping("/basket")
    public String basket(HttpSession session, RedirectAttributes redirect, Model model) {
        if (!isLoggedIn(session)) {
            redirect.addFlashAttribute("alertMessage", "로그인이 필요합니다.");
            return "redirect:/login";
        }
        model.addAttribute("member", session.getAttribute("member"));
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
