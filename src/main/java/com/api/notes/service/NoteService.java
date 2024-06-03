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
    public Note addNote(Integer userId, CreateNoteRequest request) {
        Note note = new Note();
        note.setUserId(userId);
        note.setText(request.getText());

        return noteRepository.save(note);
    }

    @Transactional
    public Note updateNote(Integer noteId, UpdateNoteRequest request) {
        Note note = noteRepository.findById(noteId).orElseThrow();
        note.setText(request.getText());

        return noteRepository.save(note);
    }

    @Transactional
    public void deleteNoteById(Integer id) {
        noteRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Note getNoteById(Integer id) {
        return noteRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Note> getNotes(Integer userId) {
        if (userId != null) {
            return noteRepository.findAllByUserId(userId);
        }
        return noteRepository.findAll();
    }
}
