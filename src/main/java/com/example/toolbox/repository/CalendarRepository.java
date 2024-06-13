package com.example.toolbox.repository;


import com.example.toolbox.model.Calendar;
import com.example.toolbox.model.Meeting;
import com.example.toolbox.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Repository
public interface CalendarRepository extends JpaRepository<Calendar,Long> {

    public List<Date> findAllByDateOrderByDateDesc();
    public List<Meeting> findAllByMeetingOrderByDateDesc();
    public List<Note> findAllByNoteAndAndDateOrderByDateDateDescNoteDesc();

}
