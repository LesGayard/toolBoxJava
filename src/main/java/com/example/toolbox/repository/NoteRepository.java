package com.example.toolbox.repository;

import com.example.toolbox.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scala.collection.immutable.List;

import java.util.Date;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> getAllByDateOOrderByDateDesc();

    Note getNoteByDate(Date date);

    Note getNoteByNoteId(Long id);


}
