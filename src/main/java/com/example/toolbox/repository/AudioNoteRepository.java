package com.example.toolbox.repository;

import com.example.toolbox.model.AudioNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AudioNoteRepository extends JpaRepository<AudioNote,Long> {
    List<Date> findAllByDateOrderByDateDesc();
    AudioNote findAudioNoteByContent(String content);
    Date findAudioNoteByDateContaining(Date date);


}
