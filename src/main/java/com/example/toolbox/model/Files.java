package com.example.toolbox.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@Table(name = "files")
class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "files_pk", nullable = false)
    private Long fileId;

    private String title;

    @OneToMany
    private List<Meeting> meetingList;

    @OneToMany
    private List<Note> noteList;



}
