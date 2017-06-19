package component.design.absfactory;

public class Shapefactory extends AbstractFactory{
	
	public Shape getShape(String shape){
		
		if(shape == null)
			return null;
		
		if(shape.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		}else if(shape.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
		
		return null;
	}

	@Override
	Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

}
