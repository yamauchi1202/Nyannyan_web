package jp.co.nyannyan.service;

import jp.co.nyannyan.entity.Admin;

public interface IAdminService {

	public Admin authentication(String id, String password);

}
