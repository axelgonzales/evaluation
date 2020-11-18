package com.pe.alicorp.core.coevaluation.service;

import java.util.List;

import com.pe.alicorp.core.coevaluation.domain.EvaluationEntity;
import com.pe.alicorp.core.coevaluation.model.EvaluationRequest;
import com.pe.alicorp.core.coevaluation.model.EvaluationSearch;

public interface EvaluationService {

    public List<EvaluationEntity> searchEvaluations(EvaluationSearch search);


    public EvaluationEntity saveEvaluation(EvaluationRequest evaluationRequest);

    public EvaluationEntity updateEvaluation(EvaluationRequest evaluationRequest, String id);

}
