package component.design.adapter;

public class AudioPlayer implements MediaPlayer{
	
	public MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		if(audioType.equalsIgnoreCase("mps")){
			System.out.println("play Mp3:"+fileName);
		}else if(audioType.equalsIgnoreCase("vlc")||audioType.equalsIgnoreCase("mp4")){
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}else {
			System.out.println("Invalid:"+audioType);
		}
	}

}
