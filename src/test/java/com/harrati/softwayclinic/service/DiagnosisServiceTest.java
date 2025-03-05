package com.harrati.softwayclinic.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DiagnosisServiceTest {

    @Test
    void diagnoseOK() {
        DiagnosisService diagnosisService = new DiagnosisService();

        Assertions.assertEquals("Traumatologie", diagnosisService.pathology(33).pathologyResult());
        Assertions.assertEquals("Cardiologie", diagnosisService.pathology(55).pathologyResult());
        Assertions.assertEquals("Traumatologie, Cardiologie", diagnosisService.pathology(15).pathologyResult());
        Assertions.assertEquals("No pathology found", diagnosisService.pathology(2).pathologyResult());

    }

    @Test
    void diagnoseKO() {
        DiagnosisService diagnosisService = new DiagnosisService();
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> diagnosisService.pathology(-2));
        Assertions.assertEquals("Health index must be positive", exception.getMessage());

    }

}