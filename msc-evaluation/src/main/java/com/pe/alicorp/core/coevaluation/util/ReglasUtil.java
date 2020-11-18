package com.pe.alicorp.core.coevaluation.util;

import com.pe.alicorp.core.coevaluation.model.EvaluationRequest;

public class ReglasUtil {

	public static boolean validar(EvaluationRequest evaluationRequest) {
		
		if (evaluationRequest.getQualification()>=1 &&  evaluationRequest.getQualification() <= 10 ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

}
