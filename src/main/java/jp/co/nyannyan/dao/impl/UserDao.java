package jp.co.nyannyan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.nyannyan.dao.IUserDao;
import jp.co.nyannyan.entity.User;

@Repository
public class UserDao implements IUserDao{

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public User findByIdAndPassword(Integer id, String pass) {
		User user = null;
		String sql = "SELECT * FROM users WHERE user_id = :userId AND password = :password";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", id);
		param.addValue("password", pass);

		List<User> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<User>(User.class));

		//resultListが空の場合、trueを返す
		boolean check = resultList.isEmpty();
		if(check) {
			return null;
		}else {
			user = resultList.get(0);
			return user;
		}
	}

	@Override
	public Integer register(String name, String sex,
			String resi, String birthday, String pass) {
		String sql = "INSERT INTO users(user_name, sex, residence, birthday, password)"
				+ " VALUES(:name, :sex, :resi, :birthday, :pass)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", name);
		param.addValue("sex", sex);
		param.addValue("resi", resi);
		param.addValue("birthday", birthday);
		param.addValue("pass", pass);

		jdbcTemplate.update(sql, param);

		User user = findMaxId();

		Integer serial = user.getUser_id();

		return serial;
	}

	@Override
	public User findMaxId() {
		User user = null;
		String sql = "SELECT user_id FROM users WHERE user_id = (SELECT max(user_id) FROM users)";

		List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		user = userList.get(0);

		return user;
	}

	public void delete(User user) {
		Integer id = user.getUser_id();
		String sql = "DELETE FROM users WHERE user_id = :userId;";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", id);

		jdbcTemplate.update(sql, param);
	}

}
