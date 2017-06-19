package component.design.filter;

public class Main {

	public static void main(String[] args) {
	      FilterManager filterManager = new FilterManager(new Target());
	      filterManager.setFilter(new AuthenticationFilter());
	      filterManager.setFilter(new DebugFilter());

	      Client client = new Client();
	      client.setFilterManager(filterManager);
	      client.sendRequest("HOME");
	   }
}
