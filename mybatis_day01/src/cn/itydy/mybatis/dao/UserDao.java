package cn.itydy.mybatis.dao;

import cn.itydy.mybatis.pojo.User;

public interface UserDao {
	
	public User findUserById(int id); 
	public void insertUser(User user);

}
