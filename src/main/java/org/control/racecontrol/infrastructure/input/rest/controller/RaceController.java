package org.control.racecontrol.infrastructure.input.rest.controller;

import jakarta.validation.Valid;
import org.control.racecontrol.domain.model.RaceResult;
import org.control.racecontrol.domain.port.input.RegisterResultUseCase;
import org.control.racecontrol.infrastructure.input.rest.dto.RaceResultRequest;
import org.control.racecontrol.infrastructure.input.rest.mapper.RaceResultMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/races")
public class RaceController {
    private final RegisterResultUseCase registerResultUseCase;

    public RaceController(RegisterResultUseCase registerResultUseCase) {
        this.registerResultUseCase = registerResultUseCase;
    }

    @PostMapping("/results")
    public ResponseEntity<Void> register(@Valid @RequestBody RaceResultRequest request) {
        RaceResult domainModel = RaceResultMapper.toDomain(request);
        registerResultUseCase.execute(domainModel);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
