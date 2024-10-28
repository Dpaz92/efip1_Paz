package Data;

import Models.Equipo;

import java.util.ArrayList;

public class EquiposData extends Data {
    private ArrayList<Equipo> equipos;

    public EquiposData() {
        equipos = new ArrayList<>();
    }

    public void setType() {
        super.type = DataType.EQUIPOS;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

}
