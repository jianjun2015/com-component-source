package component.design.absfactory;


public abstract class AbstractFactory {
	
	abstract Shape getShape(String shape);
	abstract Color getColor(String color);

}
