package org.control.racecontrol.domain.port.input;

import org.control.racecontrol.domain.model.Driver;

public interface RegisterDriverUseCase {
    // Registra un piloto en un equipo
    void execute(Driver driver);
}
