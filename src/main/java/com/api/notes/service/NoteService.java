package com.api.notes.service;

import com.api.notes.dto.CreateNoteRequest;
import com.api.notes.dto.UpdateNoteRequest;
import com.api.notes.model.Note;
import com.api.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    @Transactional
    public Note addNote(String userId, CreateNoteRequest request) {
        Note note = new Note();
        note.setUserId(userId);
        note.setText(request.getText());

        return noteRepository.save(note);
    }

    @Transactional
    public Note updateNote(Integer noteId, String userId, UpdateNoteRequest request) {
        Note note = noteRepository.findByNoteIdAndUserId(noteId, userId).orElseThrow();
        note.setText(request.getText());

        return noteRepository.save(note);
    }

    @Transactional
    public void deleteNoteById(Integer noteId, String userId) {
        noteRepository.deleteByNoteIdAndUserId(noteId, userId);
    }

    @Transactional(readOnly = true)
    public Note getNoteById(Integer noteId, String userId) {
        return noteRepository.findByNoteIdAndUserId(noteId, userId).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Note> getNotes(String userId) {
        return noteRepository.findAllByUserId(userId);
    }
}
