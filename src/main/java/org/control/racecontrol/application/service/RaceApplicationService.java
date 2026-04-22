package org.control.racecontrol.application.service;

import org.control.racecontrol.domain.model.RaceResult;
import org.control.racecontrol.domain.port.input.RegisterResultUseCase;
import org.control.racecontrol.domain.port.output.RaceRepository;

public class RaceApplicationService implements RegisterResultUseCase {
    private final RaceRepository raceRepository;

    public RaceApplicationService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public void execute(RaceResult result) {
        // Posicion unica
        if (result.getStatus() == RaceResult.Status.FINISHED) {
            boolean occupied = raceRepository.existsByRaceIdAndFinalPosition(result.getIdRace(), result.getFinalPosition());

            if (occupied) {
                throw new RuntimeException("La posicion " + result.getFinalPosition() + " ya esta ocupada.");
            }
        }

        raceRepository.saveResult(result);
    }
}
