package com.cn.smm.user;

import java.util.List;

import com.cn.smm.entity.Student;


public interface StudentMapper {
	public List<Student> selelctstudent();
	public int add(Student student);
	public int delete(int id);
	public int update(Student student);

}
