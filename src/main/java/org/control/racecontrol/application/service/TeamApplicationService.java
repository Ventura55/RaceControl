package org.control.racecontrol.application.service;

import org.control.racecontrol.domain.model.Driver;
import org.control.racecontrol.domain.port.input.RegisterDriverUseCase;
import org.control.racecontrol.domain.port.output.DriverRepository;
import org.control.racecontrol.domain.port.output.TeamRepository;

public class TeamApplicationService implements RegisterDriverUseCase {
    private final TeamRepository teamRepository;
    private final DriverRepository driverRepository;

    public TeamApplicationService(TeamRepository teamRepository, DriverRepository driverRepository) {
        this.teamRepository = teamRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public void execute(Driver driver) {
        long driverCount = teamRepository.countDriversByTeamId(driver.getIdTeam());

        if (driverCount >= 2) {
            throw new RuntimeException("Ya hay dos conductores en el equipo " + driver.getIdTeam());
        }

        driverRepository.save(driver);
    }
}
