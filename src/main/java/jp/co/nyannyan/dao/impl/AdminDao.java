package jp.co.nyannyan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.nyannyan.dao.IAdminDao;
import jp.co.nyannyan.entity.Admin;

@Repository
public class AdminDao implements IAdminDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Admin findByIdAndPassword(String id, String password) {
		String sql = "SELECT * FROM admin WHERE admin_id = :adminId AND password = :password";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("adminId", id);
		param.addValue("password", password);
		List<Admin> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Admin>(Admin.class));

		//resultListが空の場合、trueを返す
		boolean check = resultList.isEmpty();
		if(check) {
			return null;
		}else {
			Admin admin = resultList.get(0);
			return admin;
		}
	}

}
