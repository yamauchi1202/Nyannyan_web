package jp.co.nyannyan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.nyannyan.entity.Admin;
import jp.co.nyannyan.form.AdminLoginForm;
import jp.co.nyannyan.service.IAdminService;

@Controller
public class AdminController {

	@Autowired
	IAdminService IAdminService;

	@RequestMapping("/admin")
	public String getLogin(@ModelAttribute("Form") AdminLoginForm form, Model model) {

		return "admin";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String postLogin(@ModelAttribute("Form") AdminLoginForm form, Model model, HttpSession session) {

		String id = form.getAdmin_id();
		String pass = form.getPassword();

		Admin admin = IAdminService.authentication(id, pass);

		if (admin == null) {
			model.addAttribute("errmsg", "IDかパスワードが間違っています");
			return "admin";
		} else {
			session.setAttribute("admin", admin);
			return "adminMenu";
		}
	}

	@RequestMapping("/adminMenu")
	public String adminMenu(@ModelAttribute("Form") AdminLoginForm form, Model model) {

		return "adminMenu";
	}
}
