package jp.co.nyannyan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.nyannyan.dao.IUserCouponDao;
import jp.co.nyannyan.entity.UserCoupon;

@Repository
public class UserCouponDao implements IUserCouponDao{

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void userCoupon(Integer serial) {

		String sql = "INSERT INTO userCoupon(user_id, coupon_id, coupon_flag)"
				+ " VALUES(:user_id, :coupon_id, 1)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		for(int i = 0; i < 4; i++) {
			param.addValue("user_id", serial);
			param.addValue("coupon_id", i + 1);
			jdbcTemplate.update(sql, param);
		}
	}

	@Override
	public List<UserCoupon> showCoupon(Integer id) {

		String sql = "SELECT * FROM userCoupon WHERE user_id = :user_id AND coupon_flag = 1";

		MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("user_id", id);

			List<UserCoupon> CouponList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<UserCoupon>(UserCoupon.class));

			return CouponList;
	}

	public void useCoupon(Integer couponId, Integer userId) {

		String sql = "UPDATE usercoupon SET coupon_flag = 0 WHERE coupon_id = :couponId AND user_id = :userId;";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("couponId", couponId);
		param.addValue("userId", userId);

		jdbcTemplate.update(sql, param);
	}

}
