package com.pe.alicorp.core.coevaluation.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EvaluationSearch {

	@DateTimeFormat(pattern = "dd-MM-yyyy") 
	Date dateIni;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy") 
	Date dateEnd;
	
}
