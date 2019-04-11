package com.cn.smm.user;

import java.util.List;

import javax.xml.registry.infomodel.User;

public interface UserMapper {
	public int count();
	public List<com.cn.smm.entity.User> getUserList();
	public int add(com.cn.smm.entity.User u);
	public int delete(int id);
	public int update(com.cn.smm.entity.User user);
	
}
