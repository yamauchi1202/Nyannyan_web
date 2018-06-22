package jp.co.nyannyan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.nyannyan.dao.IUserDao;
import jp.co.nyannyan.entity.User;
import jp.co.nyannyan.form.DeleteForm;

@Controller
public class QuitController {

	@Autowired
	IUserDao IUserDao;

	@RequestMapping("/quit")
	public String getQuit(@ModelAttribute("Form") DeleteForm form, Model model) {

		return "quit";
	}

	@RequestMapping(value = "/quit", method = RequestMethod.POST)
	public String postQuit(@ModelAttribute("Form") DeleteForm form, Model model, HttpSession session) {

		if(form.getAlter().equals("いいえ")) {

			return "myPage";
		}else {
			User user = (User) session.getAttribute("user");

			//Daoのメソッドにログイン者の情報を渡す
			IUserDao.delete(user);
			//ログイン情報を消す
			session.removeAttribute("user");

			return "index";
		}
	}

}
