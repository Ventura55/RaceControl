package org.control.racecontrol.infrastructure.output.persistence.repository;

import org.control.racecontrol.infrastructure.output.persistence.entity.RaceResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRaceRepository extends JpaRepository<RaceResultEntity, Long> {
    boolean existsByRaceIdAndFinalPosition(Long raceId, Integer finalPosition);
}
