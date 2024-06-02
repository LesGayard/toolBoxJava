package com.example.toolbox.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@Table(name = "automotive_diagnosis")
public class AutomotiveDiagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "automotive_diagnosis_pk", nullable = false)
    private Long automotiveDiagnosisId;
    private String brand;
    private Date date;
    private String infos;
    private String vehicle;
}
