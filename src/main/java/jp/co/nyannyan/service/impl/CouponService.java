package jp.co.nyannyan.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.nyannyan.dao.ICouponDao;
import jp.co.nyannyan.dao.IUserCouponDao;
import jp.co.nyannyan.entity.Coupon;
import jp.co.nyannyan.entity.User;
import jp.co.nyannyan.entity.UserCoupon;
import jp.co.nyannyan.service.ICouponService;

@Service
public class CouponService implements ICouponService{

	@Autowired
	private IUserCouponDao IUserCouponDao;
	@Autowired
	private ICouponDao ICouponDao;


	public List<Coupon> showCoupon(User user) {

		Integer couponId;
		List<Integer> coupons = new ArrayList<>();

		int id = user.getUser_id();
		//Daoのメソッドに値を渡す
		List<UserCoupon> userCoupon = IUserCouponDao.showCoupon(id);
		for(int i = 0; i < userCoupon.size(); i++) {
			UserCoupon UserCoupon = userCoupon.get(i);
			couponId = UserCoupon.getCoupon_id();
			coupons.add(couponId);
		}
		//クーポン情報をクーポンテーブルから引き出す
		//Daoのメソッドに値を渡す
		List<Coupon> couponList = ICouponDao.couponNames(coupons);

		try {
			couponList.get(0);
		}catch(Exception e) {
			return null;
		}

		return couponList;

	}

	public void useCoupon(HttpSession session) {
		//クーポンフラグを0に更新
		Integer couponId = (Integer) session.getAttribute("useCouponId");
		User user = (User) session.getAttribute("user");
		Integer userId = user.getUser_id();

		//Daoにメソッドを渡す
		IUserCouponDao.useCoupon(couponId, userId);

	}

}
