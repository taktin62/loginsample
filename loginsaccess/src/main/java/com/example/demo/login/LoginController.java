package com.example.demo.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.views.models.UserAccountForm;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//ログイン画面のGET用コントローラー
	@GetMapping("login")
	public String getLogin(Model model) {
		model.addAttribute("user", new UserAccountForm());
		//login.htmlに画面遷移
		return "login";
	}
	@PostMapping("login")
	public String doLogin(@ModelAttribute("user") UserAccountForm form) {
		logger.debug("dologin");
		return "mypage";
	}
}