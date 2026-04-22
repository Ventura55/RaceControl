package org.control.racecontrol.domain.port.output;

import org.control.racecontrol.domain.model.Driver;

public interface DriverRepository {
    void save(Driver driver);
}
