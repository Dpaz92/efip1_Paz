package Data;

import Models.Usuario;
import Models.dto.EntrenadorDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class DataService {
    public static UsuariosData usuariosData;
    public static EntrenadoresData entrenadoresData;
    public static EquiposData equiposData;
    public static PartidosData partidosData;
    public static VideosData videosData;

    public DataService() {
        entrenadoresData = new EntrenadoresData();
        equiposData = new EquiposData();
        usuariosData = new UsuariosData();
        partidosData = new PartidosData();
        videosData = new VideosData();
    }

    public EntrenadoresData getEntrenadoresData() {
        return entrenadoresData;
    }

    private void setEntrenadoresData(EntrenadoresData entrenadoresData) {
        this.entrenadoresData = entrenadoresData;
    }

    private void setUsuariosData(UsuariosData usuariosData) {
        this.usuariosData = usuariosData;
    }

    private void setEquiposData(EquiposData equiposData) {
        this.equiposData = equiposData;
    }


    public boolean addEntrenador(EntrenadorDTO entrenador) {
        entrenadoresData.add(entrenador);
        return true;
    }

    public ArrayList<Usuario> usuarios() {
        return usuariosData.getUsuarios();
    }

    public Usuario getUsuario(String email) throws SQLException, ClassNotFoundException {
        return usuariosData.getUsuario(email);
    }

}
