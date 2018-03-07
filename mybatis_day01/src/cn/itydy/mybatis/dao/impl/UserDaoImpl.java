package cn.itydy.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itydy.mybatis.dao.UserDao;
import cn.itydy.mybatis.pojo.User;

public class UserDaoImpl implements UserDao{
	
	SqlSessionFactory factory = null;
	
	public UserDaoImpl(SqlSessionFactory factory){
		this.factory = factory;
	}

	@Override
	public User findUserById(int id) {
		SqlSession sqlSession = factory.openSession();
		User user = sqlSession.selectOne("test1.findUserById", id);
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("insertUser", user);
		sqlSession.commit();
		sqlSession.close();
		
	}

}
