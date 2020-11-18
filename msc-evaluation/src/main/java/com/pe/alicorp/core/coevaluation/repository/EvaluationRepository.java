package com.pe.alicorp.core.coevaluation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pe.alicorp.core.coevaluation.domain.EvaluationEntity;

@Repository
public interface EvaluationRepository extends MongoRepository<EvaluationEntity, String> {
	
	
	List<EvaluationEntity>  findByDateCBetween(Date ini, Date end);
	
}


