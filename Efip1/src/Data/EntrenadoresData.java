package Data;

import Models.Entrenador;
import Models.dto.EntrenadorDTO;

import java.util.ArrayList;

public class EntrenadoresData extends Data {
    private ArrayList<Entrenador> entrenadores;

    public EntrenadoresData() {
        entrenadores = new ArrayList<>();
    }

    public void setDataType() {
        super.type = DataType.ENTRENADORES;
    }

    public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public boolean add(EntrenadorDTO entrenadorDTO) {
        Entrenador entrenador = new Entrenador(entrenadores.size(), entrenadorDTO.nombre, entrenadorDTO.apellido, entrenadorDTO.email, 1);
        entrenadores.add(entrenador);
        return true;
    }

    public ArrayList<EntrenadorDTO> getEntrenadores() {
        ArrayList<EntrenadorDTO> entrenadoresDTO = new ArrayList<>();
        for (Entrenador entrenador : entrenadores) {
            entrenadoresDTO.add(entrenador.toDTO());
        }
        return entrenadoresDTO;
    }
}
