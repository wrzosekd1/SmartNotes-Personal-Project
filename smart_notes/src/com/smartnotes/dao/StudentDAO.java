package com.smartnotes.dao;

import com.smartnotes.entity.Student;

public interface StudentDAO {

	public Student getStudent(String email);

	public void saveStudent(Student student);

	public boolean studentExists(Student student);

}
