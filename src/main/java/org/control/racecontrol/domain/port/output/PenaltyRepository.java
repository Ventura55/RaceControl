package org.control.racecontrol.domain.port.output;

import org.control.racecontrol.domain.model.Penalty;

public interface PenaltyRepository {
    void save(Penalty penalty);
}
