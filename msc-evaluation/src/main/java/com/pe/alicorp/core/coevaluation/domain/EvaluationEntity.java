package com.pe.alicorp.core.coevaluation.domain;

import java.util.Date;



import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationEntity {

    @Id
    private String id;

    private String service;
    
    private String email;
    
    private String name;
    
   
    private Integer qualification;
    
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date dateC;
    
    
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date dateM;
}
