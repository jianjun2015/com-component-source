package component.design.bridge;

public class Main {

	public static void main(String[] args) {
		Shap redCircle = new Circle(100, 100, 10, new RedCircle());
		Shap greenCircle = new Circle(100, 100, 10, new GreenCircle());
		
		redCircle.draw();
		greenCircle.draw();
	}
}
