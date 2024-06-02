package com.example.toolbox.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "contact_pk", nullable = false)
    private Long id;
    private String firstname;
    private String name;
    private String email;
    private String phone;
}
