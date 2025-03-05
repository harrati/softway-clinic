package com.harrati.softwayclinic.rest;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class DiagnosisControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void diagnosisOK() throws Exception {
        mvc.perform(get("/api/diagnosis/33"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.pathologyResult").value("Traumatologie"));

        mvc.perform(get("/api/diagnosis/55"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.pathologyResult").value("Cardiologie"));
    }

    @Test
    void diagnosisKO() throws Exception {
        mvc.perform(get("/api/diagnosis/-2"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect( jsonPath("$.errorClass").value("IllegalArgumentException"));

        mvc.perform(get("/api/diagnosis/abc"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect( jsonPath("$.errorClass").value("MethodArgumentTypeMismatchException"));
    }

}