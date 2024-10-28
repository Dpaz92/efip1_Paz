package Services;

import Models.Video;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class VideoUploaderListener {
    Toolkit toolkit;
    Timer timer;

    public VideoUploaderListener() {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new CheckForUploadsTask(),
                0,        //initial delay
                10*1000);  //subsequent rate
    }

    public void stop() {
        timer.cancel();
    }

    class CheckForUploadsTask extends TimerTask {
        VideoUploader videoUploader = new VideoUploader();

        public void run() {
            //Check if something needs to update
            System.out.println("Checking for video uploads...");
            Video video = videoUploader.getNextVideoToUpload();
            if (video == null) {
                System.out.println("No hay videos pendientes, volvere a chequear en 10 segundos");
            }

            //if yes do it
        }
    }
}
