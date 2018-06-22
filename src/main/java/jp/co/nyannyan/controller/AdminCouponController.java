package jp.co.nyannyan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.nyannyan.entity.Coupon;
import jp.co.nyannyan.form.CouponForm;
import jp.co.nyannyan.service.IAdminCouponService;

@Controller
public class AdminCouponController {

	@Autowired
	IAdminCouponService IAdminCouponService;

	//クーポンメニュー押下時
	@RequestMapping("/adminCoupon")
	public String adminCoupon(@ModelAttribute("Form") CouponForm form, Model model) {

		return "adminCoupon";
	}

	//表示
	@RequestMapping("/couponShow")
	public String couponShow(@ModelAttribute("Form") CouponForm form, Model model) {

		List<Coupon> CouponList = IAdminCouponService.couponSelect();
		model.addAttribute("CouponList", CouponList);

		return "couponShow";
	}

	//登録
	@RequestMapping("/couponInsert")
	public String getCouponInsert(@ModelAttribute("Form") CouponForm form, Model model) {

		return "couponInsert";
	}

	@RequestMapping(value="/couponInsert", method = RequestMethod.POST)
	public String postCouponInsert(@ModelAttribute("Form") CouponForm form, Model model) {

		//Daoに値を渡す
		String couponName = form.getCoupon_name();
		IAdminCouponService.couponInsert(couponName);

		model.addAttribute("msg", "登録しました。");

		return "adminCoupon";
	}

	//更新
	@RequestMapping("/couponUpdate")
	public String Coupon(@ModelAttribute("Form") CouponForm form, Model model) {

		return "couponUpdate";
	}

	@RequestMapping(value="/couponUpdate", method = RequestMethod.POST)
	public String couponCofirm(@ModelAttribute("Form") CouponForm form, Model model, HttpSession session) {

		Integer id = form.getCoupon_id();
		boolean ok = IAdminCouponService.couponConfirm(id);

		if(ok) {
			session.setAttribute("couponId", id);
			return "couponUpdateConfirm";
		}else {
			model.addAttribute("errmsg", "IDが存在しません。");
			return "couponUpdate";
		}
	}

	@RequestMapping(value="/couponUpdateConfirm", method = RequestMethod.POST)
	public String couponUpdate(@ModelAttribute("Form") CouponForm form, Model model, HttpSession session) {

		Integer id = (Integer) session.getAttribute("couponId");
		String name = form.getCoupon_name();

		IAdminCouponService.couponUpdate(id, name);

		model.addAttribute("msg", "更新しました。");

		return "adminCoupon";
	}

	//削除
	@RequestMapping("/couponDelete")
	public String getDelete(@ModelAttribute("Form") CouponForm form, Model model) {

		return "couponDelete";
	}

	@RequestMapping(value = "/couponDelete", method = RequestMethod.POST)
	public String postDelete(@ModelAttribute("Form") CouponForm form, Model model) {

		Integer coupon_id = form.getCoupon_id();
		boolean ok = IAdminCouponService.couponConfirm(coupon_id);

		if(ok) {
			IAdminCouponService.couponDelete(coupon_id);
			model.addAttribute("msg", "削除しました。");
			return "adminCoupon";
		}else {
			model.addAttribute("errmsg", "IDが存在しません。");
			return "couponDelete";
		}
	}

}
