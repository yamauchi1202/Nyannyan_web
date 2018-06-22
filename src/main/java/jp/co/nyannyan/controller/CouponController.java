package jp.co.nyannyan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.nyannyan.entity.Coupon;
import jp.co.nyannyan.entity.User;
import jp.co.nyannyan.form.UseCouponForm;
import jp.co.nyannyan.form.UserCouponForm;
import jp.co.nyannyan.service.ICouponService;

@Controller
public class CouponController {

	@Autowired
	private ICouponService ICouponService;

	@RequestMapping("/coupon")
	public String getCoupon(@ModelAttribute("Form") UserCouponForm form, Model model, HttpSession session) {

		//ユーザーが持っているクーポンを表示
		//サービスクラスのメソッドに値を渡す
		User user = (User) session.getAttribute("user");
		List<Coupon> couponList = ICouponService.showCoupon(user);

		if(couponList == null) {
			model.addAttribute("couponmsg", "使用可能なクーポンはありません。");
		}else {
			session.setAttribute("CouponList", couponList);
		}

		return "coupon";
	}

	@RequestMapping(value = "/coupon", method = RequestMethod.POST)
	public String postCoupon(@ModelAttribute("Form") UseCouponForm form,@RequestParam("coupon_id") Integer coupon_id , Model model, HttpSession session) {

		//使用するクーポンのIDを受け取り、注意文を表示
		//使用するクーポンIDはセッションへ
		session.setAttribute("useCouponId", coupon_id);

		return "couponConfirm";
	}

	@RequestMapping(value = "/couponUse", method = RequestMethod.POST)
	public String useCoupon(@ModelAttribute("Form") UseCouponForm form,Model model, HttpSession session) {

		if(form.getAlter().equals("はい")) {
			//使用するクーポンのフラグを0に
			//サービスクラスのメソッドに値を渡す
			ICouponService.useCoupon(session);
			return "couponUse";
		}else {
			return "myPage";
		}
	}

}
