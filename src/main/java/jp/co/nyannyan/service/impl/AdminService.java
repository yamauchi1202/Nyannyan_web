package jp.co.nyannyan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.nyannyan.dao.IAdminDao;
import jp.co.nyannyan.entity.Admin;
import jp.co.nyannyan.service.IAdminService;

@Service
public class AdminService implements IAdminService{

	@Autowired
	private IAdminDao IAdminDao;

	public Admin authentication(String id, String password) {

		return IAdminDao.findByIdAndPassword(id, password);
	}

}
