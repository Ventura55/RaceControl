package org.control.racecontrol.infrastructure.output.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="rac_race_result")
@Data
public class RaceResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long raceId;
    private Integer driverNumber;
    private Integer gridPosition;
    private Integer finalPosition;
    private String status;
    private boolean fastestLap;
}
