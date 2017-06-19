package component.design.decrator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape circle = new Circle();
		Shape redCircle = new RedShapeDecorator(new Circle());
		Shape redRectangle = new RedShapeDecorator(new Circle());
		
		circle.draw();
		redCircle.draw();
		redRectangle.draw();

	}

}
