package com.pe.alicorp.core.coevaluation.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EvaluationResponseTest {

	EvaluationResponse mock;
	

	@Test
	public void testGetAndSet() {
		mock = new EvaluationResponse();
		mock.setMessage("EXITO");
		
		assertTrue("EXITO".equals(mock.getMessage()));
		

		
		
	}
}
