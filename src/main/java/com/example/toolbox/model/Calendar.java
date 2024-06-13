package com.example.toolbox.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "calendar")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "calendar_pk", nullable = false)
    private Long calendarId;

    /* TO DO: CREATE A UTIL METHOD BEGIN WITH DATE CHOOSE THE EVENT TO REGISTER*/
    @Column(name = "date", nullable = false)
    private Date date;

    @OneToOne
    @Column(name = "meeting", nullable = false)
    private  Meeting meeting;

    @OneToOne
    @Column(name = "note", nullable = false)
    private Note note;

    @Embedded
    @Column(name = "file", nullable = false)
    private Files files;






}
