package com.example.toolbox.repository;


import com.example.toolbox.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

@org.springframework.stereotype.Repository
public interface CalendarRepository extends JpaRepository<Calendar,Long> {

    public Date findAllByDate();
}
