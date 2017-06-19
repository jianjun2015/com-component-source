package component.design.absfactory;

public class FactoryProduce {
	
	public static AbstractFactory getFactory(String choice){
		if(choice.equalsIgnoreCase("SHAPE")){
			return new Shapefactory();
		}else if(choice.equalsIgnoreCase("color")){
			return new ColorFactory();
		}
		
		return null;
	}

}
