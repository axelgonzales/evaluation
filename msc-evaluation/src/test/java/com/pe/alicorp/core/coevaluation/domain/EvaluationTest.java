package com.pe.alicorp.core.coevaluation.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class EvaluationTest {

	EvaluationEntity mock;
	

	@Test
	public void testGetAndSet() {
		Date date = new Date();
		mock = new EvaluationEntity();
		mock.setEmail("ac.gonzalesllerena@gmail.com");
		mock.setName("Axel Gonzales Llerena");
		mock.setQualification(1);
		mock.setService("negocio");
		mock.setDateC(date);
		mock.setDateM(date);
		assertTrue("ac.gonzalesllerena@gmail.com".equals(mock.getEmail()));
		assertTrue("negocio".equals(mock.getService()));
		assertTrue("Axel Gonzales Llerena".equals(mock.getName()));
		assertTrue(1 == mock.getQualification());
		assertTrue(date.equals(mock.getDateC()));
		assertTrue(date.equals(mock.getDateM()));
		
		
	}
}
