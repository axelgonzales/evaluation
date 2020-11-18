package com.pe.alicorp.core.coevaluation.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.alicorp.core.coevaluation.domain.EvaluationEntity;
import com.pe.alicorp.core.coevaluation.model.EvaluationRequest;
import com.pe.alicorp.core.coevaluation.model.EvaluationSearch;
import com.pe.alicorp.core.coevaluation.service.EvaluationService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = EvaluationController.class)
@ActiveProfiles("test")
class EvaluationControllerTest {


	private static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
	
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
        this.evaluationList.add(new EvaluationEntity("1","negocio","ac.gonzalesllerena@gmail.com","Axel",1, new Date(), null));
        this.evaluationList.add(new EvaluationEntity("2","negocio","ddd.gonzalesllerena@gmail.com","Diana",10, new Date(), null));
        this.evaluationList.add(new EvaluationEntity("3","negocio","ssss.gonzalesllerena@gmail.com","Pierre",8, new Date(), null));

    }

    @Test
    void shouldFetchAllEvaluations() throws Exception {
    	Date dateIni = new Date();
        String strDateIni = dateFormat.format(dateIni);  
		Date dateEnd = new Date();
		String strDateEnd = dateFormat.format(dateEnd);  
    	EvaluationSearch search = new EvaluationSearch(dateIni,dateEnd);
        given(evaluationService.searchEvaluations(search)).willReturn(this.evaluationList);

        this.mockMvc.perform(get("/v1/evaluation/search?dateIni="+ strDateIni  + "&&dateEnd="+strDateEnd ))
                .andExpect(status().isOk());
    }





    @Test
    void shouldCreateNewEvaluation() throws Exception {
        EvaluationRequest evaluationRequest = new EvaluationRequest("negocio","ac.gonzalesllerena@gmail.com","Axel",1);
        given(evaluationService.saveEvaluation(evaluationRequest)).willAnswer((invocation) -> invocation.getArgument(0));

        this.mockMvc.perform(post("/v1/evaluation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(evaluationRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldUpdateEvaluation() throws Exception {
        String evaluationId = "1";
        EvaluationRequest evaluationRequest = new EvaluationRequest("negocio","ac.gonzalesllerena@gmail.com","Axel",1);
        given(evaluationService.updateEvaluation(evaluationRequest,evaluationId)).willReturn(new EvaluationEntity("1","negocio","ac.gonzalesllerena@gmail.com","Axel",1, new Date(), null));

        this.mockMvc.perform(put("/v1/evaluation/{id}", evaluationId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(evaluationRequest)))
                .andExpect(status().isCreated());
    }


}
