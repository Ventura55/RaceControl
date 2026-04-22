package org.control.racecontrol.domain.model;

public class RaceResult {
    private long id;
    private long idRace;
    private int idDriver;
    private int gridPosition;
    private int finalPosition;
    private boolean fastestLap;
    private Status status;

    public enum Status {
        FINISHED, DNF, DSQ
    }

    public RaceResult(long id, long idRace, int idDriver, int gridPosition, int finalPosition, boolean fastestLap, Status status) {
        this.id = id;
        this.idRace = idRace;
        this.idDriver = idDriver;
        this.gridPosition = gridPosition;
        this.finalPosition = finalPosition;
        this.fastestLap = fastestLap;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdRace() {
        return idRace;
    }

    public void setIdRace(long idRace) {
        this.idRace = idRace;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public int getGridPosition() {
        return gridPosition;
    }

    public void setGridPosition(int gridPosition) {
        this.gridPosition = gridPosition;
    }

    public int getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition(int finalPosition) {
        this.finalPosition = finalPosition;
    }

    public boolean isFastestLap() {
        return fastestLap;
    }

    public void setFastestLap(boolean fastestLap) {
        this.fastestLap = fastestLap;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Calculamos los puntos del piloto al vuelo no en la bd
    public int calculatePoints() {

        // Si el piloto no ha terminado la carrera o ha quedado en una posicion
        // mayor a 10 obtiene 0 puntos
        if (status != Status.FINISHED || finalPosition > 10) {
            return 0;
        }

        // En caso de que el piloto haya quedado top 10 se le da los puntos correspondientes
        int points = switch (finalPosition) {
            case 1 -> 25;
            case 2 -> 18;
            case 3 -> 15;
            case 4 -> 12;
            case 5 -> 10;
            case 6 -> 8;
            case 7 -> 6;
            case 8 -> 4;
            case 9 -> 2;
            case 10 -> 1;
            default -> 0;
        };

        // Si el piloto ha tenido la ultima vuelta rapida se le suma 1
        if (fastestLap) points++;

        return points;
    }
}
