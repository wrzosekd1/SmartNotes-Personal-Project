package com.smartnotes.dao;
//test branches
import java.util.List;

import com.smartnotes.entity.Course;
import com.smartnotes.entity.Notes;

public interface CourseDAO {

	public void saveCourse(Course course);

	public List<Course> getCourses(String email);

	public void deleteCourse(int theId);

	public Course getCourse(int theId);

	
}
