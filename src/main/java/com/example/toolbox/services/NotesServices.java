package com.example.toolbox.services;

import com.example.toolbox.repository.AudioNoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotesServices {

    private AudioNoteRepository noteRepository;

    Logger logger = LoggerFactory.getLogger(NotesServices.class);
}
