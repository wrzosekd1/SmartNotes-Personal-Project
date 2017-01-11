package com.smartnotes.dao;

import java.util.List;

import com.smartnotes.entity.Notes;

public interface NotesDAO {

	List<Notes> getNotes(int theId);

	void saveNotes(Notes notes);

	void deleteNotes(int theId);

	Notes getNote(int theId);

	void updateNotes(Notes notes, int notesId);

}
