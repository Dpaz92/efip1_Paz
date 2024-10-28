package Data;

import Models.Partido;

import java.util.ArrayList;

public class PartidosData {
    private ArrayList<Partido> partidos;

    public PartidosData() {
        partidos = new ArrayList<>();
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
}
