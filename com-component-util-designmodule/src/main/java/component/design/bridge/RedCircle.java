package component.design.bridge;

public class RedCircle implements DrawAPI {

	@Override
	public void drawCircle(int radius, int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("draw circle red:radius+"+radius+",X:"+x+",Y:"+y);
	}

}
