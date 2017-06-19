package component.design.strategy;

public class Main {

	public static void main(String[] args) {
		Strategy add = new OperationAdd();
		Strategy sub = new OperationSub();
		Strategy div = new OperationDiv();
		
		System.out.println(add.doOperation(10, 2));
		System.out.println(sub.doOperation(10, 2));
		System.out.println(div.doOperation(10, 2));
	}
}
