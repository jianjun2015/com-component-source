package component.design.decrator;

public abstract class ShapeDecorator implements Shape{

	protected Shape decoratorShape;
	
	public ShapeDecorator(Shape decoratorShape) {
		// TODO Auto-generated constructor stub
		this.decoratorShape = decoratorShape;
	}
	
	public void draw(){
		decoratorShape.draw();
	}
}
