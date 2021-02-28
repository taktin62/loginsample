package com.example.demo.controllers;

import java.security.Principal;

import com.example.demo.domain.UserAccount;
import com.example.demo.domain.UserId;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String rootForm(Model model) {
        return "login";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccessForm(@AuthenticationPrincipal UserAccount userAccount, Model model) {
        String username = userAccount.getUsername();
        model.addAttribute("username", username);
        return "loginSuccess";
    }

    @GetMapping("/invalidSession")
    public String invalidSessionForm(Model model) {
        return "login";
    }

}