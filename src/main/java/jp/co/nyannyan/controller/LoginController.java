package jp.co.nyannyan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.nyannyan.entity.User;
import jp.co.nyannyan.form.LoginForm;
import jp.co.nyannyan.service.ILoginService;

@Controller
public class LoginController {

	@Autowired
	ILoginService ILoginService;

	@RequestMapping("/login")
	public String getLogin(@ModelAttribute("Form") LoginForm form, Model model) {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(@ModelAttribute("Form") LoginForm form, Model model, HttpSession session) {

		//フォームの値取得
		Integer id = form.getUser_id();
		String pass = form.getPassword();

		//値をサービスのメソッドに渡す
		User user = ILoginService.login(id, pass);

		if (user == null) {
			model.addAttribute("errmsg", "IDかパスワードが間違っています");
			return "login";
		} else {
			session.setAttribute("user", user);
			return "index";
		}
	}


	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model, HttpSession session) {
		session.invalidate();

		return "logout";
	}


}
