package com.smartnotes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smartnotes.entity.Course;
import com.smartnotes.entity.Notes;

@Repository
public class NotesDAOImpl implements NotesDAO {

	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Notes> getNotes(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		
		Query<Notes> theQuery = currentSession.createQuery("from Notes where courseId=:courseId", Notes.class);
		theQuery.setParameter("courseId", theId);
		
		// execute query and get result list of notes with mathing courseID
		List<Notes> notes = theQuery.getResultList();

	
		return notes;
	}

	@Override
	public void saveNotes(Notes notes) {
		Session currentSession = sessionFactory.getCurrentSession();

		//insert new notes
		currentSession.save(notes);


	}

	@Override
	public void updateNotes(Notes notes, int notesId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query updateQuery = currentSession.createQuery("update Notes set description=:descript, text=:text where id=:notesId");
		updateQuery.setParameter("descript", notes.getDescription());
		updateQuery.setParameter("text", notes.getText());
		updateQuery.setParameter("notesId", notesId);

		//update old notes
		updateQuery.executeUpdate();

	}

	@Override
	public void deleteNotes(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Notes where id=:notesId");
		theQuery.setParameter("notesId", theId);
		
		//delete notes
		theQuery.executeUpdate();

	}

	@Override
	public Notes getNote(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get notes for a class
		Notes notes = currentSession.get(Notes.class, theId);

		return notes;
	}


}
