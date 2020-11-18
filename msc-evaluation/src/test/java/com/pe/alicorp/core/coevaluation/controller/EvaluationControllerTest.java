package com.pe.alicorp.core.coevaluation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.alicorp.core.coevaluation.domain.EvaluationEntity;
import com.pe.alicorp.core.coevaluation.controller.EvaluationController;
import com.pe.alicorp.core.coevaluation.model.EvaluationRequest;
import com.pe.alicorp.core.coevaluation.service.EvaluationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = EvaluationController.class)
@ActiveProfiles("test")
class EvaluationControllerTest {

    /*
    TODO: mock tracing

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EvaluationService evaluationService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<EvaluationEntity> evaluationList;

    @BeforeEach
    void setUp() {
        this.evaluationList = new ArrayList<>();
        this.evaluationList.add(new EvaluationEntity(1L, "evaluation 1"));
        this.evaluationList.add(new EvaluationEntity(2L, "evaluation 2"));
        this.evaluationList.add(new EvaluationEntity(3L, "evaluation 3"));

        objectMapper.registerModule(new ProblemModule());
        objectMapper.registerModule(new ConstraintViolationProblemModule());
    }

    @Test
    void shouldFetchAllEvaluations() throws Exception {
        given(evaluationService.findAllEvaluations()).willReturn(this.evaluationList);

        this.mockMvc.perform(get("/v1/evaluation"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(evaluationList.size())));
    }

    @Test
    void shouldFindEvaluationById() throws Exception {
        Long evaluationId = 1L;
        EvaluationEntity evaluation = new EvaluationEntity(evaluationId, "text 1");
        given(evaluationService.findEvaluationById(evaluationId)).willReturn(Optional.of(evaluation));

        this.mockMvc.perform(get("/v1/evaluation/{id}", evaluationId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text", is(evaluation.getText())))
        ;
    }

    @Test
    void shouldReturn404WhenFetchingNonExistingEvaluation() throws Exception {
        Long evaluationId = 1L;
        given(evaluationService.findEvaluationById(evaluationId)).willReturn(Optional.empty());

        this.mockMvc.perform(get("v1/evaluation/{id}", evaluationId))
                .andExpect(status().isNotFound());

    }

    @Test
    void shouldCreateNewEvaluation() throws Exception {
        EvaluationRequest evaluationRequest = new  EvaluationRequest(5L, "new evaluationRequest");
        given(evaluationService.saveEvaluation(evaluationRequest)).willAnswer((invocation) -> invocation.getArgument(0));

        this.mockMvc.perform(post("/v1/evaluation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(evaluationRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldUpdateEvaluation() throws Exception {
        Long evaluationId = 1L;
        EvaluationRequest evaluationRequest = new EvaluationRequest(evaluationId, "evaluation updated");
        given(evaluationService.findEvaluationById(evaluationId)).willReturn(Optional.of(new EvaluationEntity(evaluationId, "evaluation updated")));

        this.mockMvc.perform(put("/v1/evaluation/{id}", evaluationRequest.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(evaluationRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldDeleteEvaluation() throws Exception {
        Long evaluationId = 1L;
        EvaluationEntity evaluation = new EvaluationEntity(evaluationId, "Some text");
        given(evaluationService.findEvaluationById(evaluationId)).willReturn(Optional.of(evaluation));
        doNothing().when(evaluationService).deleteEvaluationById(evaluation.getId());

        this.mockMvc.perform(delete("/v1/evaluation/{id}", evaluation.getId()))
                .andExpect(status().isAccepted());
    }
     */
}
