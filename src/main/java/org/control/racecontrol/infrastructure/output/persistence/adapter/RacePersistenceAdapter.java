package org.control.racecontrol.infrastructure.output.persistence.adapter;

import org.control.racecontrol.domain.model.RaceResult;
import org.control.racecontrol.domain.port.output.RaceRepository;
import org.control.racecontrol.infrastructure.output.persistence.entity.RaceResultEntity;
import org.control.racecontrol.infrastructure.output.persistence.repository.SpringDataRaceRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RacePersistenceAdapter implements RaceRepository {
    private final SpringDataRaceRepository jpaRepository;

    public RacePersistenceAdapter(SpringDataRaceRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void saveResult(RaceResult result) {
        RaceResultEntity entity = new RaceResultEntity();
        entity.setRaceId(result.getIdRace());
        entity.setGridPosition(result.getGridPosition());
        entity.setFinalPosition(result.getFinalPosition());
        entity.setStatus(result.getStatus().name());
        entity.setFastestLap(result.isFastestLap());

        jpaRepository.save(entity);
    }

    @Override
    public boolean existsByRaceIdAndFinalPosition(Long raceId, Integer finalPosition) {
        return jpaRepository.existsByRaceIdAndFinalPosition(raceId, finalPosition);
    }

    @Override
    public List<RaceResult> findResultsByRaceId(Long raceId) {
        return List.of();
    }
}
