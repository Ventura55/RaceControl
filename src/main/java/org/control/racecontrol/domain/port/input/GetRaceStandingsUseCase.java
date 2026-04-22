package org.control.racecontrol.domain.port.input;

import org.control.racecontrol.domain.model.RaceResult;

import java.util.List;

public interface GetRaceStandingsUseCase {
    // Obtiene los resultados de una carrera
    List<RaceResult> getResults(Long raceId);
}
