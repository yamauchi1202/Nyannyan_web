package jp.co.nyannyan.dao;

import java.util.List;

import jp.co.nyannyan.entity.Coupon;

public interface ICouponDao {

	public List<Coupon> couponNames(List<Integer> coupons);

	public List<Coupon> findAll();

	public void insert(String coupon_name);

	public void update(Integer coupon_id, String coupon_name);

	public List<Coupon> findById(Integer coupon_id);

	public void delete(Integer coupon_id);

}
