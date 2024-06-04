package com.api.notes.controller;

import com.api.notes.dto.CreateNoteRequest;
import com.api.notes.dto.UpdateNoteRequest;
import com.api.notes.exceptions.NoUserException;
import com.api.notes.model.Note;
import com.api.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {
    @Autowired
    NoteService noteService;

    @PostMapping("/notes")
    public Note addNote(@RequestHeader("X-User-Id") String userId, @RequestBody CreateNoteRequest request) {
        return noteService.addNote(validateUserId(userId), request);
    }

    @PutMapping("/notes/{noteId}")
    public Note udpateNote(@RequestHeader("X-User-Id") String userId, @PathVariable Integer noteId, @RequestBody UpdateNoteRequest request) {
        return noteService.updateNote(noteId, validateUserId(userId), request);
    }

    @DeleteMapping("/notes/{noteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(@RequestHeader("X-User-Id") String userId, @PathVariable Integer noteId) {
        noteService.deleteNoteById(noteId, validateUserId(userId));
    }

    @GetMapping("/notes/{noteId}")
    public Note getNoteById(@RequestHeader("X-User-Id") String userId, @PathVariable Integer noteId) {
        return noteService.getNoteById(noteId, validateUserId(userId));
    }

    @GetMapping("/notes")
    public List<Note> getNotes(@RequestHeader("X-User-Id") String userId) {
        return noteService.getNotes(validateUserId(userId));
    }

    String validateUserId(String userId) {
    	// NOTE: if there is no userId provided, we do not provide any information with the exception
    	//       as to not provide any hints about what the issue might be to a nefarious caller
        if(userId == null) {
        	throw new NoUserException();
        }
        
        String sanitizedUserId = userId.trim();
        if(userId.isEmpty()) {
        	throw new NoUserException();
        }
        
        return sanitizedUserId;
    }
}
