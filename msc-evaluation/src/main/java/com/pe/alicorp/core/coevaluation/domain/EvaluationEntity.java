package com.pe.alicorp.core.coevaluation.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="evaluations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String service;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String name;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateC;
    
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    @Column(nullable = false)
    private Integer qualification;
    
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    @Column(nullable = false)
    private Date dateM;
}
