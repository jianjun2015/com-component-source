package component.design.bridge;

public abstract class Shap {

	protected DrawAPI drawAPI;
	
	public Shap(DrawAPI drawAPI) {
		// TODO Auto-generated constructor stub
		this.drawAPI = drawAPI;
	}
	
	public abstract void draw();
}
