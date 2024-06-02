package com.example.toolbox.repository;

import com.example.toolbox.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting,Long> {
    Meeting getMeetingsByDate(Date date);
}
