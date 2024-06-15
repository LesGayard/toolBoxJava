package com.example.toolbox.services;

import com.example.toolbox.model.Note;
import com.example.toolbox.repository.AudioNoteRepository;
import com.example.toolbox.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NotesServices {
    private NoteRepository noteRepository;
    private AudioNoteRepository audioNoteRepository;
    Logger logger = LoggerFactory.getLogger(NotesServices.class);

    public List<Note> getAllNotesListedInTwoListTypesByDate() {
        List<Note> noteList = new ArrayList<>();
        logger.info("List : " + noteList.size());
        List<Note> audioList = null;
        List<Note> writtenList = null;
        audioList = noteRepository.getAllByAudioNotesOrderByDateDateDesc();
        noteList.addAll(audioList);
        logger.info("List : " + noteList.size());
        writtenList = noteRepository.getAllByWrittenNotesOrderByDateDateDesc();
        noteList.addAll(writtenList);
        logger.info("List : "+ noteList.size());
        return noteList;
    }


    public Note searchNoteByWrittenNoteAndTitle(String input) {
        logger.info("Search Note By Title");
        Note noteFound = null;
        logger.info("Note to find : " + noteFound.toString());
        noteFound = noteRepository.getNoteByWrittenNotesAndTitleMatchesRegex(input);
        logger.info("Repo Called Regex : " + noteFound.getTitle());
        return noteFound;
          /*  public void searchTitle(String title){
        Pattern pattern = Pattern.compile();
        Matcher matcher = pattern.matcher(title);
    }*/

    }
    public Note addNote(Note note){
        logger.info("Create note with input : " + note.getTitle());
        Note noteAdded = null;
        logger.info("Input ID ? :" + note.getNoteId());
        if(noteRepository.existsById(note.getNoteId())){
            /* Update method;;;*/

            logger.info("Update input");
            noteAdded.setDate(new Date());
            noteAdded = updateNote(note);
            logger.info("title + date : " + noteAdded.getTitle() + noteAdded.getDate());
        }else{
            noteAdded.setDate(new Date());
            noteAdded = noteRepository.save(note);
            logger.info("title + id  + date: " + noteAdded.getDate()+ noteAdded.getTitle() + noteAdded.getNoteId());
        }
        return noteAdded;
    }

    public Note updateNote(Note input){
        logger.info("Update Note");
        Note note = null;
        note.setDate(new Date());
        logger.info("Note to Update : " + note.toString());
        note = noteRepository.saveAndFlush(input);
        logger.info("Before return Update : " + note.getNoteId() +note.getTitle());
        return note;
    }


}
