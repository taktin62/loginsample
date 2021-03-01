package com.example.demo.controllers;

import com.example.demo.controllers.form.UpdatePasswordForm;
import com.example.demo.domain.UserAccount;
import com.example.demo.domain.UserNotFoundException;
import com.example.demo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    /**
     * Logger
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // TODO: Exceptionがスローされたときに共通エラーに飛ばすように設定する
    private final UserService userService;

    @Autowired
    HomeController(UserService userService) {
        this.userService = userService;
    }

	@GetMapping("/menuDetails")
    public String getDetails(@AuthenticationPrincipal UserAccount userAccount, Model model) {
        model.addAttribute("username", userAccount.getUsername());
        // menuDetails.htmlに画面遷移
        return "menuDetails";
    }

	@GetMapping("/menuEdit")
    public String getEdit(Model model, UpdatePasswordForm updatePasswordForm) {
        model.addAttribute("updatePasswordForm", updatePasswordForm);
        // menuEdit.htmlに画面遷移
        return "menuEdit";
    }

    // TODO: パスワードチェックバリデーションの適用
    @PostMapping("/updatePassword")
    public String updatePassword(@AuthenticationPrincipal UserAccount userAccount, Model model, @Validated UpdatePasswordForm updatePasswordForm) throws UserNotFoundException {
        userService.updatePassword(userAccount.getUserId(), updatePasswordForm.getPassword());
        model.addAttribute("username", userAccount.getUsername());
        return "menuDetails";
    }

	@GetMapping("/menuConfirmation")
	public String withdrawalConfirmation(Model model) {
        // menuConfirmation.htmlに画面遷移
        return "menuConfirmation";
    }


	@PostMapping("/menuDone")
	public String withdrawal(@AuthenticationPrincipal UserAccount userAccount, Model model) {
        try {
            userService.withdraw(userAccount.getUserId());
        } catch (UserNotFoundException unfe){
            logger.warn(String.format("User not found: user_id = [%s]", userAccount.getUserId()));
        }

        //TODO: ログアウト

        // menuDone.htmlに画面遷移
        return "menuDone";
    }



}
