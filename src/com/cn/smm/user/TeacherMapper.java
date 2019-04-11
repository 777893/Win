package com.cn.smm.user;

import java.util.List;

import com.cn.smm.entity.Teacher;

public interface TeacherMapper {
	public List<Teacher> selectteacher();
	public int add(Teacher teacher);
	public int delete(int id);
	public int update(Teacher teahcer);

}
