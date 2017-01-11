package com.smartnotes.service;

import java.util.List;

import com.smartnotes.entity.Course;
import com.smartnotes.entity.Notes;
import com.smartnotes.entity.Student;

public interface StudentService {

	public Student getStudent(String email);

	public void saveStudent(Student student);

	public boolean studentExists(Student student);

	public void saveCourse(Course course);

	public List<Course> getCourses(String attribute);

	public void deletecourse(int theId);

	public Course getCourse(int theId);

	public List<Notes> getNotes(int theId);

	public void saveNotes(Notes notes);

	public void deleteNotes(int theId);

	public Notes getNote(int theId);

	public void updateNotes(Notes notes, int notesId);

}
