package jp.co.nyannyan.dao;

import jp.co.nyannyan.entity.User;

public interface IUserDao {

	public User findByIdAndPassword(Integer id, String pass);

	public Integer register(String name, String sex,
			String resi, String birthday, String pass);

	public User findMaxId();

	public void delete(User user);

}
