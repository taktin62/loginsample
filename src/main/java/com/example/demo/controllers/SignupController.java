package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController {
	@GetMapping("/signup")
    public String getSignUp(Model model) {
        // signup.htmlに画面遷移
        return "signup";
    }


	@GetMapping("/signupConfirmation")
	public String getSignupSuccess(Model model) {
        // signupConfirmation.htmlに画面遷移
        return "signupConfirmation";
    }


	@GetMapping("/signupDone")
	public String getSignupDone(Model model) {
        // signupDone.htmlに画面遷移
        return "signupDone";
    }



}
