package jp.co.nyannyan.service;

import jp.co.nyannyan.entity.User;

public interface ILoginService {

	public User login(Integer id, String pass);
}
