package com.example.toolbox.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import scala.math.Numeric;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@Entity
@Table(name = "audio_note")
public class AudioNote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date date;
    private Numeric content;
    @OneToMany
    @JoinColumn(name = "note_pk")
    private List<Note> notes;
}
