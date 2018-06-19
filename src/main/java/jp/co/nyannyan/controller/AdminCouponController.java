package jp.co.nyannyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jp.co.nyannyan.service.IAdminCouponService;

@Controller
public class AdminCouponController {

	@Autowired
	IAdminCouponService IAdminCouponService;
}
