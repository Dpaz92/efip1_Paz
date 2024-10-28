package Models;

import java.time.LocalDateTime;

public class Partido {
    private int id;
    private int idEquipo;
    private LocalDateTime fechaHora;

    public Partido(int id, int idEquipo, LocalDateTime fechaHora) {
        this.id = id;
        this.idEquipo = idEquipo;
        this.fechaHora = fechaHora;
    }

    public int getId() {
        return id;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}
