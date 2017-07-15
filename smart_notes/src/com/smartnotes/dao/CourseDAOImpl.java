package com.smartnotes.dao;
//test
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smartnotes.entity.Course;
import com.smartnotes.entity.Student;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCourse(Course course) {
		Session currentSession = sessionFactory.getCurrentSession();

		//save course
		currentSession.save(course);

	}

	@Override
	public List<Course> getCourses(String email) {

		Session currentSession = sessionFactory.getCurrentSession();

		
		Query<Course> theQuery = currentSession.createQuery("from Course where student=:email", Course.class);
		theQuery.setParameter("email", email);
		
		// get all courses for a student and put it in a list
		List<Course> courses = theQuery.getResultList();

		return courses;
	}

	@Override
	public void deleteCourse(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete course with matching ID
		Query theQuery = currentSession.createQuery("delete from Course where id=:courseId");
		theQuery.setParameter("courseId", theId);
		
		
		theQuery.executeUpdate();
		
	}

	@Override
	public Course getCourse(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		//get course with matching ID
		Course course = currentSession.get(Course.class, theId);

		return course;
	}

}
