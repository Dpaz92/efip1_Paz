package Data;

import Models.Video;

import java.util.ArrayList;

public class VideosData {
    private ArrayList<Video> videos;
    public VideosData() {
        this.videos = new ArrayList<>();
    }

    public ArrayList<Video> getVideos() {
        return videos;
    }
}
