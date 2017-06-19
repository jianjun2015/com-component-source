package component.design.absfactory;


public class ColorFactory extends AbstractFactory{
	
	public Color getColor(String color){
		
		if(color == null)
			return null;
		
		if(color.equalsIgnoreCase("BluE")){
			return new Blue();
		}else if(color.equalsIgnoreCase("red")) {
			return new Red();
		}
		
		return null;
	}

	@Override
	Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

}
