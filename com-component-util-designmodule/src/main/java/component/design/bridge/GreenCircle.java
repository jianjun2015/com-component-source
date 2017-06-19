package component.design.bridge;

public class GreenCircle implements DrawAPI{

	@Override
	public void drawCircle(int radius, int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("draw circle green:radius+"+radius+",X:"+x+",Y:"+y);
	}

}
