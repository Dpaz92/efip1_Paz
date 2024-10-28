package Services;

import Data.DataService;

import Models.Entrenador;
import Models.Equipo;
import Models.Partido;
import Models.Video;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VideoUploader {
    LocalDateTime time;

    public VideoUploader() {
        time = LocalDateTime.now();
    }


    public Video getNextVideoToUpload() {
        List<Partido> partidos = DataService.partidosData.getPartidos().stream().filter(partido -> {
            return partido.getFechaHora().isBefore(time);
        }).toList();
        for (Partido partido : partidos) {
            Video video = DataService.videosData.getVideos().stream().filter(v -> {
                return v.getIdPartido() == partido.getId() && !v.isUploaded();
            }).findFirst().orElse(null);
            if (video != null) {
                return video;
            }
        }
        return null;
    }

    public boolean uploadVideo(Video video) throws InterruptedException {
        Partido partido = getPartidoFromVideo(video);
        Equipo equipo = getEquipoFromPartido(partido);
        Entrenador entrenador = getEntrenadorFromEquipo(equipo);
        HudlHandler hudlHandler = new HudlHandler();
        hudlHandler.upload();
    }

    private Partido getPartidoFromVideo(Video video) {
        Partido partido = DataService.partidosData.getPartidos().stream().filter(partido1 -> {
            return partido1.getId() == video.getIdPartido();
        }).findFirst().orElse(null);

        if (partido == null) {
            throw new VideoWithouMatchException();
        }

        return partido;
    }
}
