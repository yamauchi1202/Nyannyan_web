package jp.co.nyannyan.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import jp.co.nyannyan.entity.Coupon;
import jp.co.nyannyan.entity.User;

public interface ICouponService {

	public List<Coupon> showCoupon(User user);

	public void useCoupon(HttpSession session);
}
