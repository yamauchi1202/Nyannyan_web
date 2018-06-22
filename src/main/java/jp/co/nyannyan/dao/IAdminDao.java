package jp.co.nyannyan.dao;

import jp.co.nyannyan.entity.Admin;

public interface IAdminDao {

	public Admin findByIdAndPassword(String id, String password);

}
