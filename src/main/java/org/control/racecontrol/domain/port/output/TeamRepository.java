package org.control.racecontrol.domain.port.output;

import org.control.racecontrol.domain.model.Team;

import java.util.Optional;

public interface TeamRepository {
    Optional<Team> findById(Long id);
    void save(Team team);

    // Contamos conductores para la regla de max 2 pilotos
    long countDriversByTeamId(Long teamId);
}
