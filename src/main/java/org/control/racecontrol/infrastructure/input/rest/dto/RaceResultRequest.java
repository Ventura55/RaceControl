package org.control.racecontrol.infrastructure.input.rest.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class RaceResultRequest {
    @NotNull
    private Long raceId;
    @NotNull
    private Integer driverNumber;

    @Min(1) @Max(20)
    private Integer gridPosition;

    @Min(1) @Max(20)
    private Integer finalPosition;

    private String status;
    private boolean fastestLap;
}
