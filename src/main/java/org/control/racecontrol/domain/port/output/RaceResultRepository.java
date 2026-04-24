package org.control.racecontrol.domain.port.output;

import org.control.racecontrol.domain.model.RaceResult;

public interface RaceResultRepository {
    void save(RaceResult result);

    // Buscamos que no se repita el numero de finalPosition si
    // estan calificados
    int findFinalPositionByIdDriver(int idDriver);
}
