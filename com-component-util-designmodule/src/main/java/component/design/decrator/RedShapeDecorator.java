package component.design.decrator;

public class RedShapeDecorator extends ShapeDecorator{

	public RedShapeDecorator(Shape decoratorShape) {
		super(decoratorShape);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(){
		decoratorShape.draw();
		setRedBorder(decoratorShape);
	}
	
	private void setRedBorder(Shape decoratorShape){
		System.out.println("Border Color:Red");
	}

}
