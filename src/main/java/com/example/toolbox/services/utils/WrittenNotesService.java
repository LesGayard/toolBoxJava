package com.example.toolbox.services.utils;

import com.example.toolbox.model.WrittenNote;
import com.example.toolbox.repository.WrittenNoteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

public class WrittenNotesService {
    private WrittenNoteRepository noteRepository;
    private final String FILE_NAME = "src/main/resources/newNote.txt";
    private Scanner scanner = new Scanner(System.in);
    Logger logger = LoggerFactory.getLogger(WrittenNotesService.class);

    @AfterEach
    @BeforeEach
    public void cleanUpFiles() {
        logger.info("Delete file");
        File targetFile = new File(FILE_NAME);
        targetFile.delete();
    }

    public void createFile() throws IOException {
        Path path = Paths.get(FILE_NAME);
        Files.createFile(path);

    }
    public WrittenNote saveOrUpdate(WrittenNote input) throws IOException{
        WrittenNote note = new WrittenNote();
        logger.info("note must be null : " + note.toString());
        if(!noteRepository.existsById(input.getWrittenNoteId())){
            note = saveNote(input);
            logger.info("Return new note : " + note.toString());
        }else {
            note = updateNote(input);
            logger.info("Return Updated note : " + note.toString());
        }
        return note;
    }
    private WrittenNote saveNote(WrittenNote note) throws IOException {
        logger.info("Input to save: " + note.toString());
        WrittenNote toSave = new WrittenNote();
        logger.info("must be null : " + toSave.getWrittenNoteId());
        toSave.setDate(new Date());
        toSave.setTitle(note.getTitle());
        toSave.setContent(note.getContent());
        logger.info("Entity before repo saving : " + toSave.getTitle());
        noteRepository.save(toSave);
        logger.info("File Creation");
        BufferedWriter writer = write(note);
        return toSave;
    }

    private WrittenNote updateNote(WrittenNote note) throws IOException{
        logger.info("Entity to Update : " + note.toString());
        noteRepository.findById(note.getWrittenNoteId());
        logger.info("Entity id : "+ note.getWrittenNoteId());
        noteRepository.saveAndFlush(note);
        logger.info("File Creation :");
        /* TO DO CREATE UPDATE FILE */
        BufferedWriter writer = write(note);
        return note;
    }

    public void deleteNote(WrittenNote input){
        logger.info("Delete Input : " + input.getTitle());
        noteRepository.delete(input);
        try {
            noteRepository.findById(input.getWrittenNoteId());
           logger.info("NOT FOUND : " + input.getWrittenNoteId());
        }catch (Exception e){
            logger.error("Entity Success deletion : " + e.getLocalizedMessage());
        }
    }

    public BufferedWriter write(WrittenNote inputNote) throws IOException {
        File file = new File("src/main/resources/note.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            Boolean createdFile = file.createNewFile();
            if(createdFile){
                logger.info("New Note created start writing : ");
                bufferedWriter.write(inputNote.getDate().toString());
                bufferedWriter.newLine();
                bufferedWriter.write(inputNote.getTitle());
                logger.info("next Line New Note");
                bufferedWriter.newLine();
                bufferedWriter.write(inputNote.getContent());
                logger.info("Buffer string : " + bufferedWriter.toString());
                bufferedWriter.close();
                return bufferedWriter;

            }
        } catch (Exception e) {
            logger.error("Error : " + e.getLocalizedMessage());
        }
        return bufferedWriter;
    }


}
