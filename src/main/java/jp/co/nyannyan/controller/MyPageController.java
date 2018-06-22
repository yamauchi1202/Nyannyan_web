package jp.co.nyannyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.nyannyan.form.LoginForm;

@Controller
public class MyPageController {

	@RequestMapping("/myPage")
	public String mypage(@ModelAttribute("Form") LoginForm form, Model model) {

		return "myPage";
	}
}
