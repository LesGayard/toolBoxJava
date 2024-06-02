package com.example.toolbox.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "note_pk", nullable = false)
    private Long noteId;
    @OneToMany
    @JoinColumn(name = "audio_note_pk")
    private List<AudioNote> audioNotes;
    @OneToMany
    @JoinColumn(name = "written_note_pk")
    private List<WrittenNote> writtenNotes;

}
