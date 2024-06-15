package com.example.toolbox.repository;

import com.example.toolbox.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting,Long> {
    Meeting findMeetingByDate(Date date);
    List<Meeting>findAllByDateOrderByDateDesc();
    Long findMeetingsByMeetingId(Long id);
    /* TO DO: SEARCH IN THE STRING DYNAMIC */

    Meeting findMeetingsByDateMatchesRegex(Date date);
    long deleteByMeetingId(@NonNull Long meetingId);
}
