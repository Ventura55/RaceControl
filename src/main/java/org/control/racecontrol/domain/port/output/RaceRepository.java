package org.control.racecontrol.domain.port.output;

import org.control.racecontrol.domain.model.Race;

public interface RaceRepository {
    void save(Race race);
}
