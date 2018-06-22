package jp.co.nyannyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.nyannyan.form.InsertForm;
import jp.co.nyannyan.residents.Residents;
import jp.co.nyannyan.service.IInsertService;

@Controller
public class InsertController {

	@Autowired
	IInsertService IInsertService;

	@Autowired
	Residents Residents;

	@RequestMapping("/insert")
	public String getInsert(@ModelAttribute("Form") InsertForm form, Model model) {

		//プルダウン用の47都道府県のデータ
		model.addAttribute("residents", Residents.resi);

		return "insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String postInsert(@ModelAttribute("Form") InsertForm form, Model model) {

		//フォームの値取得
		String name = form.getUser_name();
		String sex = form.getSex();
		String resi = form.getResidence();
		String birthday = form.getYear() + "年" + form.getMonth() + "月" + form.getDay() + "日";
		String pass = form.getPassword();

		//値をサービスのメソッドに渡す
		Integer serial = IInsertService.register(name, sex, resi, birthday, pass);
		//表示用のシリアルナンバー

		String msg = "登録しました。あなたのシリアルIDは" + serial + "です";
		model.addAttribute("msg", msg);

		return "index";


	}
}
