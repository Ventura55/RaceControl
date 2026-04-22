package org.control.racecontrol.infrastructure.input.rest.mapper;

import org.control.racecontrol.domain.model.RaceResult;
import org.control.racecontrol.infrastructure.input.rest.dto.RaceResultRequest;

public class RaceResultMapper {
    public static RaceResult toDomain(RaceResultRequest request) {
        return new RaceResult(
                0L,
                request.getRaceId(),
                request.getDriverNumber(),
                request.getGridPosition(),
                request.getFinalPosition(),
                request.isFastestLap(),
                RaceResult.Status.valueOf(request.getStatus().toUpperCase())
        );
    }
}
