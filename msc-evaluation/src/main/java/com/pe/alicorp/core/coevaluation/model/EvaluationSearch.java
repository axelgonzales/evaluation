package com.pe.alicorp.core.coevaluation.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationSearch {

	@DateTimeFormat(pattern = "dd-MM-yyyy") 
	Date dateIni;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy") 
	Date dateEnd;
	
}
