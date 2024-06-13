package com.example.toolbox.repository;

import com.example.toolbox.model.AudioNote;
import com.example.toolbox.model.Note;
import com.example.toolbox.model.WrittenNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scala.collection.immutable.List;

import java.util.Date;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> getAllByDateOrderByDateDesc();

    Note getNoteByDate(Date date);

    Note getNoteByNoteId(Long id);
    List<AudioNote> getAllByAudioNotesOrderByDateDateDesc();
    AudioNote getNoteByAudioNotesAndTitle(String title);
    List<WrittenNote> getAllByWrittenNotesOrderByDateDateDesc();
    WrittenNote getNoteByWrittenNotesAndTitle(String title);


}
