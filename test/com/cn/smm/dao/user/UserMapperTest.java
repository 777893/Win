package com.cn.smm.dao.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.jms.Session;

import org.apache.ibatis.session.SqlSession;

import com.cn.smm.entity.User;
import com.cn.smm.user.UserMapper;
import com.cn.smm.utils.MyBatisUtil;

public class UserMapperTest {
	private static void main(String[]args){
		/*Scanner sc=new Scanner(System.in);
		User u=new User();
		System.out.println("请输入id");
		u.setId(sc.next());
		System.out.println("请输入name");
		u.setName(sc.next());
		System.out.println("请输入password");
		u.setPassword(sc.next());*/
		select();
		add();
		delete(1);
		update();
	}

	private static void update() {
		int upd=0;
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			User user=new User();
			user.setId("1");
			user.setAge("2");
			user.setName("3");
			user.setPassword("4");
			upd=sqlSession.getMapper(UserMapper.class).update(user);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		System.out.println(upd);
		
	}

	private static void delete(int id) {
		int d=0;
		SqlSession sqlSession =null;
		try {
			 sqlSession=MyBatisUtil.createSqlSession();
			 d=sqlSession.getMapper(UserMapper.class).delete(id);
			 sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		System.out.println(d);
	}

	private static void add() {
		int p=0;
		User u=new User();
		u.setId("11");
		u.setAge("22");
		u.setName("33");
		u.setPassword("44");
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			p=sqlSession.getMapper(UserMapper.class).add(u);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		System.out.println(p);
	}

	private static void select() {
		SqlSession sqlSession=null;
		List<User> userList=new ArrayList<User>();
		try {
			sqlSession =MyBatisUtil.createSqlSession();
			//第一种方式：调用selectList方法执行查询操作
			//第二种方法：调用getMapper(Mapper.class)方法执行dao接口方法来实现对数据库的查询操作
			
			userList=sqlSession.getMapper(UserMapper.class).getUserList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for(User u:userList){
			System.out.println(u.getId()+"\t"+u.getName()+"\t"+u.getPassword()+"\t"+u.getAge());
		}		
	}
}
