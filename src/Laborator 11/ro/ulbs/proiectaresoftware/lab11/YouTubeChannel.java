package Laborator;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel {
    private String channelName;

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    public void uploadVideo(String title) {
        System.out.println("{"+ channelName + "} uploaded a new video: " + title);
    }
}