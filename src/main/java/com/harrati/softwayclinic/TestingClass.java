package com.harrati.softwayclinic;

import com.harrati.softwayclinic.service.DiagnosisService;

public class TestingClass {
    public static void main(String[] args) {
        DiagnosisService diagnosisService = new DiagnosisService();

        System.out.println(diagnosisService.pathology(33).pathologyResult());
        System.out.println(diagnosisService.pathology(55).pathologyResult());
        System.out.println(diagnosisService.pathology(15).pathologyResult());
        System.out.println(diagnosisService.pathology(2).pathologyResult());
        System.out.println(diagnosisService.pathology(-2).pathologyResult());

    }
}
