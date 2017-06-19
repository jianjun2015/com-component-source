package component.design.adapter;

public class Mp4Player implements AdvancedMediaPlayer{

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playMP4(String fileName) {
		// TODO Auto-generated method stub
		System.out.println("play Mp4:"+fileName);
	}

}
