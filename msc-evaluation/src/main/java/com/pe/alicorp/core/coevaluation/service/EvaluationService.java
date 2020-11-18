package com.pe.alicorp.core.coevaluation.service;

import com.pe.alicorp.core.coevaluation.domain.EvaluationEntity;
import com.pe.alicorp.core.coevaluation.model.EvaluationRequest;
import com.pe.alicorp.core.coevaluation.model.EvaluationSearch;

import java.util.List;
import java.util.Optional;

public interface EvaluationService {

    public List<EvaluationEntity> searchEvaluations(EvaluationSearch search);

    public Optional<EvaluationEntity> findEvaluationById(String id);

    public EvaluationEntity saveEvaluation(EvaluationRequest evaluationRequest);

    public EvaluationEntity updateEvaluation(EvaluationRequest evaluationRequest, String id);

}
