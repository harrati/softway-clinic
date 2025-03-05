package com.harrati.softwayclinic.rest;

import com.harrati.softwayclinic.dto.PathologyDTO;
import com.harrati.softwayclinic.service.DiagnosisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diagnosis")
@RequiredArgsConstructor
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @GetMapping("/{index}")
    public ResponseEntity<PathologyDTO> diagnosis(@PathVariable("index") int healthIndex) {
        return ResponseEntity.ok().body(diagnosisService.pathology(healthIndex));
    }

}
