package jp.co.nyannyan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.nyannyan.dao.ICouponDao;
import jp.co.nyannyan.entity.Coupon;
import jp.co.nyannyan.service.IAdminCouponService;

@Service
public class AdminCouponService implements IAdminCouponService {

	@Autowired
	private ICouponDao ICouponDao;

	public List<Coupon> couponSelect() {

		List<Coupon> CouponList = ICouponDao.findAll();

		return CouponList;
	}

	public void couponInsert(String couponName) {
		ICouponDao.insert(couponName);
	}

	public boolean couponConfirm(Integer coupon_id) {
		List<Coupon> couponList = ICouponDao.findById(coupon_id);
		try {
			couponList.get(0);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public void couponUpdate(Integer coupon_id, String coupon_name) {
		ICouponDao.update(coupon_id, coupon_name);
	}

	public void couponDelete(Integer coupon_id) {
		ICouponDao.delete(coupon_id);
	}

}
