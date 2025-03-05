package com.harrati.softwayclinic.service;

import com.harrati.softwayclinic.dto.PathologyDTO;
import com.harrati.softwayclinic.helper.CardiologyCalculator;
import com.harrati.softwayclinic.helper.PathologyCalculator;
import com.harrati.softwayclinic.helper.TraumatologyCalculator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class DiagnosisService {

    public PathologyDTO pathology(int healthIndex) throws IllegalArgumentException {
        if(healthIndex < 0) {
            throw new IllegalArgumentException("Health index must be positive");
        }

        List<PathologyCalculator> calculators = List.of(new TraumatologyCalculator(), new CardiologyCalculator());

        List<String> pathologies = calculators.stream()
                .map(calculator -> calculatePathology(calculator, healthIndex))
                .filter(Objects::nonNull)
                .toList();

        if (pathologies.isEmpty()) {
            return new PathologyDTO("No pathology found");
        }

        return new PathologyDTO(String.join(", ", pathologies));

    }

    private String calculatePathology(PathologyCalculator calculator, int healthIndex) {
        return calculator.calculate(healthIndex);
    }
}
