package cn.itydy.mybatis.mapper;

import cn.itydy.mybatis.pojo.User;

public interface UserMapper {

	public User findUserById(int id); 
	public void insertUser(User user);
}
