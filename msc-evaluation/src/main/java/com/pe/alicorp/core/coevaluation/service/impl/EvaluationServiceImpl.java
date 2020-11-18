package com.pe.alicorp.core.coevaluation.service.impl;

import com.pe.alicorp.core.coevaluation.domain.EvaluationEntity;
import com.pe.alicorp.core.coevaluation.repository.EvaluationRepository;
import com.pe.alicorp.core.coevaluation.model.EvaluationRequest;
import com.pe.alicorp.core.coevaluation.model.EvaluationSearch;
import com.pe.alicorp.core.coevaluation.service.impl.mapper.EvaluationDTOToEvaluationEntityMapper;
import com.pe.alicorp.core.coevaluation.util.ReglasUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pe.alicorp.core.coevaluation.service.EvaluationService;
import com.pe.alicorp.core.coevaluation.exception.ModelNotFoundException;
import com.pe.alicorp.core.coevaluation.exception.RuleException;
import com.pe.alicorp.core.coevaluation.constant.Constant;


import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private EvaluationDTOToEvaluationEntityMapper evaluationDTOToEvaluationEntityMapper = new EvaluationDTOToEvaluationEntityMapper();


    @Autowired
    public EvaluationServiceImpl(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public List<EvaluationEntity> searchEvaluations(EvaluationSearch search) {
    	System.out.println("search.get Ini " + search.getDateIni());
    	System.out.println("search.get fin " + search.getDateEnd());
        List<EvaluationEntity> listEvaluation = evaluationRepository.findByDateCBetween(search.getDateIni(),search.getDateEnd());

        log.info("GET ALL Evaluation MESSAGE TEST" );
        return listEvaluation;
    }

    public Optional<EvaluationEntity> findEvaluationById(String id) {

        Optional<EvaluationEntity> optionalEvaluation = evaluationRepository.findById(id);

        log.info("GET Evaluation/ MESSAGE TEST" );
        
        return optionalEvaluation;
    }

    public EvaluationEntity saveEvaluation(EvaluationRequest evaluationRequest) {
    	
    	if (ReglasUtil.validar(evaluationRequest)) {
			throw new RuleException("SE INGRESO UNA CALIFICACIÓN INVALIDA");
		}
    	
    	EvaluationEntity evaluationEntity = evaluationDTOToEvaluationEntityMapper.evaluationDTOToEvaluationEntityMapper(evaluationRequest);
		evaluationEntity.setDateC(new Date());
    	
    	evaluationEntity  = evaluationRepository.save(evaluationEntity);

        log.info("POST Evaluation MESSAGE TEST" );
        
        return evaluationEntity;
    }

    public EvaluationEntity updateEvaluation(EvaluationRequest evaluationRequest, String id) {
    	
    	if (ReglasUtil.validar(evaluationRequest)) {
			throw new RuleException("SE INGRESO UNA CALIFICACIÓN INVALIDA");
		}


        return evaluationRepository.findById(id).map(evaluationRequestObje -> {
            evaluationRequest.setId(id);
            EvaluationEntity evaluation = evaluationRepository.save(evaluationDTOToEvaluationEntityMapper.evaluationDTOToEvaluationEntityMapper(evaluationRequest));
            log.info("UPDATE Evaluation MESSAGE TEST" );
            
        return evaluation;

        })
        .orElseThrow(() -> new ModelNotFoundException(Constant.PERSONA_NOT_FOUND));
    }


}