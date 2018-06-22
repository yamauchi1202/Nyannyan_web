package jp.co.nyannyan.service;

import java.util.List;

import jp.co.nyannyan.entity.Coupon;

public interface IAdminCouponService {

	public List<Coupon> couponSelect();

	public void couponInsert(String couponName);

	public boolean couponConfirm(Integer coupon_id);

	public void couponUpdate(Integer coupon_id, String coupon_name);

	public void couponDelete(Integer coupon_id);

}
