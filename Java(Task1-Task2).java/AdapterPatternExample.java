interface MediaPlayer {
    void play(String fileType, String fileName);
}

class MP3Player implements MediaPlayer {
    @Override
    public void play(String fileType, String fileName) {
        if (fileType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else {
            System.out.println("Invalid format for MP3 player");
        }
    }
}

class MP4Player {
    public void playMP4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    private MP4Player mp4Player;

    public MediaAdapter(String fileType) {
        if (fileType.equalsIgnoreCase("mp4")) {
            mp4Player = new MP4Player();
        }
    }

    @Override
    public void play(String fileType, String fileName) {
        if (fileType.equalsIgnoreCase("mp4")) {
            mp4Player.playMP4(fileName);
        }
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        MediaPlayer player = new MP3Player();
        player.play("mp3", "song.mp3");

        MediaAdapter adapter = new MediaAdapter("mp4");
        adapter.play("mp4", "video.mp4");
    }
}
