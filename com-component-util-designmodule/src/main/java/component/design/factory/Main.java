package component.design.factory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shapefactory factory = new Shapefactory();
		
		factory.getShape("rectangle").draw();
		factory.getShape("square").draw();

	}

}
