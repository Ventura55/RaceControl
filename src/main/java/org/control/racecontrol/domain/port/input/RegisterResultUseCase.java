package org.control.racecontrol.domain.port.input;

import org.control.racecontrol.domain.model.RaceResult;

public interface RegisterResultUseCase {
    // Registra el resultado de un piloto
    void execute(RaceResult result);
}
