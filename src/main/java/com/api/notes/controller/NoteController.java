package com.api.notes.controller;

import com.api.notes.dto.CreateNoteRequest;
import com.api.notes.dto.UpdateNoteRequest;
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
    public Note addNote(@RequestParam(required = true) Integer userId, @RequestBody CreateNoteRequest request) {
        return noteService.addNote(userId, request);
    }

    @PutMapping("/notes/{id}")
    public Note udpateNote(@PathVariable Integer id, @RequestBody UpdateNoteRequest request) {
        return noteService.updateNote(id, request);
    }

    @DeleteMapping("/notes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(@PathVariable Integer id) {
        noteService.deleteNoteById(id);
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable Integer id) {
        return noteService.getNoteById(id);
    }

    @GetMapping("/notes")
    public List<Note> getNotes(@RequestParam(required = false) Integer userId) {
        return noteService.getNotes(userId);
    }

}
