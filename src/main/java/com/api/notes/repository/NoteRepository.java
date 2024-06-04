package com.api.notes.repository;

import com.api.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findAllByUserId(String userId);

	Optional<Note> findByNoteIdAndUserId(Integer noteId, String userId);

	void deleteByNoteIdAndUserId(Integer noteId, String userId);
}