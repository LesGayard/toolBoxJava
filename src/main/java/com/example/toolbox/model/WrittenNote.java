package com.example.toolbox.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "written_note")
public class WrittenNote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "written_note_pk", nullable = false)
    private Long writtenNoteId;
    private int id;
    private Date date;
    private String content;
    @OneToMany
    @JoinColumn(name = "note_pk")
    private List<Note> notes;
}
