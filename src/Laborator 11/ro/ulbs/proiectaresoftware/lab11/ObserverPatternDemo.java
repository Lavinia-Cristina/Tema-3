package Laborator;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel("Tech Explained");

        MediaInterested media1 = new MediaInterested("CNN");
        MediaInterested media2 = new MediaInterested("FoxNews");

        String message1 = "Observer Pattern in Java";
        channel.uploadVideo(message1);
        media1.doSomeLogic(message1);
        media2.doSomeLogic(message1);

        String message2 = "Singleton Pattern in Java";
        channel.uploadVideo(message2);
        media1.doSomeLogic(message2);
    }
}
