package com.pe.alicorp.core.coevaluation.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class EvaluationSearchTest {

	EvaluationSearch mock;
	

	@Test
	public void testGetAndSet() {
		Date dateIni = new Date();
		Date dateEnd = new Date();
		mock = new EvaluationSearch();
		mock.setDateEnd(dateEnd);
		mock.setDateIni(dateIni);
		
		assertTrue(dateEnd.equals(mock.getDateEnd()));
		assertTrue(dateIni.equals(mock.getDateIni()));

		
		
	}
}
