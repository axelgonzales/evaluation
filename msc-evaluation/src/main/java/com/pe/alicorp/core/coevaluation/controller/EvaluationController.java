package com.pe.alicorp.core.coevaluation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.alicorp.core.coevaluation.constant.Constant;
import com.pe.alicorp.core.coevaluation.domain.EvaluationEntity;
import com.pe.alicorp.core.coevaluation.exception.ExceptionResponse;
import com.pe.alicorp.core.coevaluation.model.EvaluationRequest;
import com.pe.alicorp.core.coevaluation.model.EvaluationResponse;
import com.pe.alicorp.core.coevaluation.model.EvaluationSearch;
import com.pe.alicorp.core.coevaluation.service.EvaluationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("v1/evaluation")
@Api(value = "EvaluationController", produces = "application/json", tags = { "Controlador Evaluation" })
public class EvaluationController {

    private final EvaluationService evaluationService;

    @Autowired
    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping("search")
    public List<EvaluationEntity> searchEvaluations(EvaluationSearch search) {
        return evaluationService.searchEvaluations(search);
    }

    @ApiOperation(value = "Obtiene Evaluation por ID", tags = { "Controlador Evaluation" })
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Evaluation encontrada", response = EvaluationEntity.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<EvaluationEntity> getEvaluationById(@PathVariable String id) {
        return evaluationService.findEvaluationById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Registra Evaluation", tags = { "Controlador Evaluation" })
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Evaluation registrada", response = EvaluationRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<EvaluationResponse> createEvaluation(@RequestBody @Validated EvaluationRequest evaluationRequest) {
        evaluationService.saveEvaluation(evaluationRequest);
        return new ResponseEntity<>(new EvaluationResponse(Constant.REG_INS_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Actualiza Evaluation", tags = { "Controlador Evaluation" })
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Evaluation actualizada", response = EvaluationRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<EvaluationResponse> updateEvaluation(@PathVariable String id, @RequestBody EvaluationRequest evaluationRequest) throws Exception {
        evaluationService.updateEvaluation(evaluationRequest, id);
        return new ResponseEntity<>(new EvaluationResponse(Constant.REG_ACT_ACCEPTED), HttpStatus.CREATED);
    }


}
