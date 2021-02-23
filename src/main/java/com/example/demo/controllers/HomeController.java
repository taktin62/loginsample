package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/menuDetails")
    public String getDetails(Model model) {
        // menuDetails.htmlに画面遷移
        return "menuDetails";
    }


	@GetMapping("/menuEdit")
    public String getEdit(Model model) {
        // menuEdit.htmlに画面遷移
        return "menuEdit";
    }


	@GetMapping("/menuConfirmation")
	public String getConfiramtion(Model model) {
        // menuConfirmation.htmlに画面遷移
        return "menuConfirmation";
    }


	@GetMapping("/menuDone")
	public String getdone(Model model) {
        // menuDone.htmlに画面遷移
        return "menuDone";
    }



}
