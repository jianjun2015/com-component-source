package component.design.absfactory;

public class Main {
	
	public static void main(String[] args) {
		
		AbstractFactory factory = FactoryProduce.getFactory("shape");
		factory.getShape("square").draw();
		factory.getShape("rectangle").draw();
		
		AbstractFactory factory2 = FactoryProduce.getFactory("color");
		factory2.getColor("red").color();
		factory2.getColor("blue").color();
	}

}
