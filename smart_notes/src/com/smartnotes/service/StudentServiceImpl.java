package com.smartnotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartnotes.dao.CourseDAO;
import com.smartnotes.dao.NotesDAO;
import com.smartnotes.dao.StudentDAO;
import com.smartnotes.entity.Course;
import com.smartnotes.entity.Notes;
import com.smartnotes.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO customerDAO;
	
	@Autowired
	private CourseDAO courseDAO;
	
	@Autowired
	private NotesDAO notesDAO;

	@Override
	@Transactional
	public Student getStudent(String email) {
		return customerDAO.getStudent(email);
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		customerDAO.saveStudent(student);
		
	}

	@Override
	@Transactional
	public boolean studentExists(Student student) {
		return customerDAO.studentExists(student);
	}

	@Override
	@Transactional
	public void saveCourse(Course course) {
		courseDAO.saveCourse(course);
		
	}

	@Override
	@Transactional
	public List<Course> getCourses(String email) {
		return courseDAO.getCourses(email);
	}

	@Override
	@Transactional
	public void deletecourse(int theId) {
		courseDAO.deleteCourse(theId);
	}

	@Override
	@Transactional
	public Course getCourse(int theId) {
		return courseDAO.getCourse(theId);
	}

	@Override
	@Transactional
	public List<Notes> getNotes(int theId) {
		return notesDAO.getNotes(theId);
	}

	@Override
	@Transactional
	public void saveNotes(Notes notes) {
		notesDAO.saveNotes(notes);
		
	}

	@Override
	@Transactional
	public void deleteNotes(int theId) {
		notesDAO.deleteNotes(theId);
		
	}

	@Override
	@Transactional
	public Notes getNote(int theId) {
		return notesDAO.getNote(theId);
	}

	@Override
	@Transactional
	public void updateNotes(Notes notes, int notesId) {
		notesDAO.updateNotes(notes,notesId);
		
	}

}
