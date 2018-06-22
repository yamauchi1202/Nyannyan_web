package jp.co.nyannyan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.nyannyan.dao.IUserCouponDao;
import jp.co.nyannyan.dao.IUserDao;
import jp.co.nyannyan.service.IInsertService;

@Service
public class InsertService implements IInsertService{

	@Autowired
	private IUserDao IUserDao;
	@Autowired
	private IUserCouponDao IUserCouponDao;

	public Integer register (String name, String sex,
			String resi, String birthday, String pass) {

		//Daoのメソッドに登録予定の情報を渡す
		//返り値でユーザーのシリアルナンバーをもらう
		Integer serial = IUserDao.register(name, sex, resi, birthday, pass);

		//ユーザーにクーポン券を付与
		IUserCouponDao.userCoupon(serial);

		//indexでシリアルナンバーを表示し、ユーザーに記憶してもらう
		return serial;
	}

}
