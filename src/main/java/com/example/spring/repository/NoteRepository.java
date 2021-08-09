package com.example.spring.repository;

import com.example.spring.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

  @Query("select note from com.example.spring.entity.Note note")
  List<Note> findAllNotes();

  Note findNoteById(Long NoteId);
}
