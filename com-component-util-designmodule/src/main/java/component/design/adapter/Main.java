package component.design.adapter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "mp3");
		audioPlayer.play("mp4", "mp4");
		audioPlayer.play("vlc", "vlc");
		audioPlayer.play("mpr", "mp3");

	}

}
