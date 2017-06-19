package component.design.filter;

public class AuthenticationFilter implements Filter {

	@Override
	public void excute(String request) {
		// TODO Auto-generated method stub
		System.out.println("Authenticating request: " + request);
	}

}
