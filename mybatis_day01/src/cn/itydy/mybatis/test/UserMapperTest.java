package cn.itydy.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itydy.mybatis.mapper.UserMapper;
import cn.itydy.mybatis.pojo.User;

public class UserMapperTest {
	
	SqlSessionFactory factory = null;
	@Before
	public void init() throws Exception {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		factory = builder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));

	}
	
	@Test
	public void TestFindUserById(){
		SqlSession sqlSession = factory.openSession();
    	UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    	User user = mapper.findUserById(27);
    	System.out.println(user);
    	sqlSession.close();
	}
}
