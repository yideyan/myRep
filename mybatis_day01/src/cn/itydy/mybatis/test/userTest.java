package cn.itydy.mybatis.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itydy.mybatis.pojo.User;

public class userTest {
	
	SqlSessionFactory factory = null;
	@Before
	public void init() throws Exception {
		//获取sessionFactory对象
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		factory = builder.build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception{
		//1.获取sqlSession
		SqlSession sqlSession = factory.openSession();
		//2.使用sqlSession的方法
		User user = sqlSession.selectOne("findUserById",10);
		System.out.println(user);
		//关闭sqlsession
		sqlSession.close();
	}
	@Test
	public void testFindUserByUsername() throws Exception{
		//1.获取sqlSession
		SqlSession sqlSession = factory.openSession();
		//2.使用sqlSession的方法
		List<User> users = sqlSession.selectList("findUserByUsername", "张");
		System.out.println(users);
		//关闭sqlsession
		sqlSession.close();
	}
	
	@Test
	public void testInsertUser() throws Exception{
		//1.获取sqlSession
		SqlSession sqlSession = factory.openSession();
		User user = new User();
		user.setUsername("迪丽热巴");
		user.setBirthday(new Date());
		user.setSex("0");
		user.setAddress("新疆");
		
		sqlSession.insert("insertUser", user);
		
		sqlSession.commit();
		System.out.println(user);
		//关闭sqlsession
		sqlSession.close();
	}
	@Test
	public void testdeleteUserById() throws Exception{
		//1.获取sqlSession
		SqlSession sqlSession = factory.openSession();
		sqlSession.delete("deleteUserById", 28);
		
		sqlSession.commit();
		//关闭sqlsession
		sqlSession.close();
	}
	@Test
	public void testupdateUser() throws Exception{
		//1.获取sqlSession
		SqlSession sqlSession = factory.openSession();
		User user = new User();
		user.setId(27);
		user.setUsername("迪丽热巴");
		user.setBirthday(new Date());
		user.setSex("0");
		user.setAddress("北京");
		sqlSession.update("updateUser", user);
		
		sqlSession.commit();
		//关闭sqlsession
		sqlSession.close();
	}
}















