package Models;

public class Equipo {
    private int id;
    private String sexo;
    private int division;
    private String categoria;
    private int creadoPorUsuarioId;

    public Equipo(int id, String sexo, int division, String categoria, int creadoPorUsuarioId) {
        this.id = id;
        this.sexo = sexo;
        this.division = division;
        this.categoria = categoria;
        this.creadoPorUsuarioId = creadoPorUsuarioId;
    }

    public int getId() {
        return id;
    }

    public String getSexo() {
        return sexo;
    }

    public int getDivision() {
        return division;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCreadoPorUsuarioId() {
        return creadoPorUsuarioId;
    }

}
