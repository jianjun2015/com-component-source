package component.design.bridge;

public class Circle extends Shap{

	private int x,y,radius;
	
	public Circle(int x,int y,int radius,DrawAPI drawAPI) {
		// TODO Auto-generated constructor stub
		super(drawAPI);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		drawAPI.drawCircle(radius, x, y);
		
	}

}
