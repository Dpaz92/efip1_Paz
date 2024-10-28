package Models;

public class Video {
    private int id;
    private int idPartido;
    private String route;
    private String urlHudl;
    private boolean isUploaded;

    public Video(int id, int idPartido, String route, String urlHudl, boolean isUploaded) {
        this.id = id;
        this.idPartido = idPartido;
        this.route = route;
        this.urlHudl = urlHudl;
        this.isUploaded = isUploaded;
    }

    public int getId() {
        return id;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public String getRoute() {
        return route;
    }

    public String getUrlHudl() {
        return urlHudl;
    }

    public boolean isUploaded() {
        return isUploaded;
    }
}
