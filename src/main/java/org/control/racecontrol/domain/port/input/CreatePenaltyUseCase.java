package org.control.racecontrol.domain.port.input;

import org.control.racecontrol.domain.model.Penalty;

public interface CreatePenaltyUseCase {
    void execute(Penalty penalty);
}
