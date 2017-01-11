package com.smartnotes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smartnotes.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Student getStudent(String email) {

		Session currentSession = sessionFactory.getCurrentSession();

		//search for student with matching email
		Student student = currentSession.get(Student.class, email);

		return student;
	}

	@Override
	public void saveStudent(Student student) {
		Session currentSession = sessionFactory.getCurrentSession();

		//save the student
		currentSession.save(student);

	}

	@Override
	public boolean studentExists(Student student) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//search for student with matching email and password
		List<Student> theStudents=
				currentSession.createQuery("from Student s where"
						+ " s.email='"+student.getEmail()+"' AND s.password='"+student.getPassword()+"'").getResultList();
		
		//if a result is found return true else return false
		if(theStudents.size()==1){
			return true;
		}else{
			return false;
		}
		
	}

}
