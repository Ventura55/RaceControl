package org.control.racecontrol.domain.port.output;

import org.control.racecontrol.domain.model.Team;

public interface TeamRepository {
    void save(Team team);
}
