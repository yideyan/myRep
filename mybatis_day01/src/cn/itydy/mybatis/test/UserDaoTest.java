package cn.itydy.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itydy.mybatis.dao.UserDao;
import cn.itydy.mybatis.dao.impl.UserDaoImpl;
import cn.itydy.mybatis.pojo.User;

public class UserDaoTest {
	
	SqlSessionFactory factory = null;
	@Before
	public void init() throws Exception {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		factory = builder.build(inputStream);

	}
	
	@Test
	public void TestFindUserById(){
		UserDao userDao = new UserDaoImpl(factory);
		User user = userDao.findUserById(27);
		System.out.println(user);
	}
}
