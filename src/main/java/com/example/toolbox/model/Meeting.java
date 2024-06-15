package com.example.toolbox.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Data
@Entity
@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "meeting_pk", nullable = false)
    private Long id;
    private String firstname;
    @ManyToOne(targetEntity = Contact.class)
    @JoinColumn(name = "contact_pk")
    private Contact contact;
    private Date date;
    private String title;


}
