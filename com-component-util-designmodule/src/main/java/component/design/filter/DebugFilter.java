package component.design.filter;

public class DebugFilter implements Filter {

	@Override
	public void excute(String request) {
		// TODO Auto-generated method stub
		System.out.println("request log: " + request);
	}

}
