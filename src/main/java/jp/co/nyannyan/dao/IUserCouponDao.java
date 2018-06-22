package jp.co.nyannyan.dao;

import java.util.List;

import jp.co.nyannyan.entity.UserCoupon;

public interface IUserCouponDao {

	public void userCoupon(Integer serial);

	public List<UserCoupon> showCoupon(Integer id);

	public void useCoupon(Integer couponId, Integer userId);

}
