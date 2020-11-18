package com.pe.alicorp.core.coevaluation.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EvaluationRequestTest {


	EvaluationRequest mock;
	

	@Test
	public void testGetAndSet() {
		mock = new EvaluationRequest();
		mock.setEmail("ac.gonzalesllerena@gmail.com");
		mock.setName("Axel Gonzales Llerena");
		mock.setQualification(1);
		mock.setService("negocio");
		
		assertTrue("ac.gonzalesllerena@gmail.com".equals(mock.getEmail()));
		assertTrue("negocio".equals(mock.getService()));
		assertTrue("Axel Gonzales Llerena".equals(mock.getName()));
		assertTrue(1 == mock.getQualification());

		
		
	}
}
