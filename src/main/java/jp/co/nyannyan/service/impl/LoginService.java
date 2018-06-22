package jp.co.nyannyan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.nyannyan.dao.IUserDao;
import jp.co.nyannyan.entity.User;
import jp.co.nyannyan.service.ILoginService;

@Service
public class LoginService implements ILoginService {

	@Autowired
	IUserDao IUserDao;

	public User login(Integer id, String pass) {
		User user = null;
		//Daoのメソッドにidとpassを渡す
		user = IUserDao.findByIdAndPassword(id, pass);
		if(user == null) {
			return null;
		}else {
			return user;
		}
	}

}
