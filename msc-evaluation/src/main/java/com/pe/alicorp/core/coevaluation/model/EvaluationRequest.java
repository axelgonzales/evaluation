package com.pe.alicorp.core.coevaluation.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationRequest {
	
	
    @NotNull
    private String service;
    
    @Email
    @NotBlank
    private String email;
    
    @NotBlank
    private String name;
    
    @NotNull
    private Integer qualification;
    
    
}
