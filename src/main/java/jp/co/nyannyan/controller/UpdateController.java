package jp.co.nyannyan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.nyannyan.entity.User;
import jp.co.nyannyan.form.UpdateForm;
import jp.co.nyannyan.residents.Residents;

@Controller
public class UpdateController {

	@Autowired
	Residents Residents;

	@RequestMapping("/update")
	public String getUpdate(@ModelAttribute("Form") UpdateForm form, Model model, HttpSession session) {
		//ユーザーの情報を受け取り表示
		//生年月日のみ分けてmodelにset
		List <String> birth = new ArrayList<>();
		User user = (User) session.getAttribute("user");
		String birthday = user.getBirthday();
		String[] year = birthday.split("年", -1);
		String[] month = year[1].split("月", -1);
		String[] day = month[1].split("日", -1);
		birth.add(year[0]);birth.add(month[0]);birth.add(day[0]);
		model.addAttribute("birthday", birth);
		//47都道府県のデータ
		model.addAttribute("residents", Residents.resi);
		String sex = user.getSex();
		model.addAttribute("sex", sex);

		return "update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String postUpdate(@ModelAttribute("Form") UpdateForm form, Model model) {


		return "myPage";
	}

}
