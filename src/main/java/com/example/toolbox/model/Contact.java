package com.example.toolbox.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "contact_pk", nullable = false)
    private Long id;
    private Date date;
    private String firstname;
    private String name;
    private String email;
    private String phone;
    @OneToMany
    @JoinColumn(name = "date")
    private List<Meeting> modifications;
}
