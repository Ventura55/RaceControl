package org.control.racecontrol.domain.port.output;

import org.control.racecontrol.domain.model.RaceResult;

import java.util.List;

public interface RaceRepository {
    void saveResult(RaceResult result);

    // Regla para que no haya 2 pilotos en la misma finalPosition
    boolean existsByRaceIdAndFinalPosition(Long raceId, Integer finalPosition);
    List<RaceResult> findResultsByRaceId(Long raceId);
}
