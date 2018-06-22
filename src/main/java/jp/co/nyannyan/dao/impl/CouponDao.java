package jp.co.nyannyan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.nyannyan.dao.ICouponDao;
import jp.co.nyannyan.entity.Coupon;

@Repository
public class CouponDao implements ICouponDao {

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Coupon> couponNames(List<Integer> coupons){

		List<Coupon> CouponList = new ArrayList<>();

		String sql = "SELECT * FROM coupon WHERE coupon_id = :coupon_id";
		MapSqlParameterSource param = new MapSqlParameterSource();

		for(int i = 0; i < coupons.size(); i++) {
			Integer couponId = coupons.get(i);
			param.addValue("coupon_id", couponId);
			List<Coupon> Coupon = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Coupon>(Coupon.class));
			CouponList.add(Coupon.get(0));
		}

		return CouponList;
	}

	public List<Coupon> findAll(){

		String sql = "SELECT * FROM coupon";
		MapSqlParameterSource param = new MapSqlParameterSource();
		List<Coupon> CouponList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Coupon>(Coupon.class));

		return CouponList;
	}

	public void insert(String coupon_name) {
		String sql = "INSERT INTO coupon(coupon_name) VALUES(:couponName);";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("couponName", coupon_name);

		jdbcTemplate.update(sql, param);
	}

	public void update(Integer coupon_id, String coupon_name) {

		String sql = "UPDATE coupon SET coupon_name = :couponName WHERE coupon_id = :couponId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("couponName", coupon_name);
		param.addValue("couponId", coupon_id);

		jdbcTemplate.update(sql, param);
	}

	public List<Coupon> findById(Integer coupon_id) {
		String sql = "SELECT * FROM coupon WHERE coupon_id = :couponId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("couponId", coupon_id);
		List<Coupon> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Coupon>(Coupon.class));

		return resultList;
	}

	public void delete(Integer coupon_id) {
		String sql = "DELETE FROM coupon WHERE coupon_id = :couponId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("couponId", coupon_id);

		jdbcTemplate.update(sql, param);
	}
}
