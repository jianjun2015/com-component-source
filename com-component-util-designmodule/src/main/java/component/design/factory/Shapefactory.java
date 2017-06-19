package component.design.factory;

public class Shapefactory {
	
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

}
