package com.pe.alicorp.core.coevaluation.service.impl.mapper;

import org.modelmapper.ModelMapper;
import com.pe.alicorp.core.coevaluation.domain.EvaluationEntity;
import com.pe.alicorp.core.coevaluation.model.EvaluationRequest;

public class EvaluationDTOToEvaluationEntityMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public EvaluationEntity evaluationDTOToEvaluationEntityMapper(EvaluationRequest evaluationRequest) {
        return modelMapper.map(evaluationRequest, EvaluationEntity.class);
    }
}