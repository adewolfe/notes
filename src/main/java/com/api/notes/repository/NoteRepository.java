package com.api.notes.repository;

import com.api.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findAllByUserId(Integer userId);
}