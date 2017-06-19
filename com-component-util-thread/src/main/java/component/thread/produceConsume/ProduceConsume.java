package component.thread.produceConsume;

public class ProduceConsume {

	public static int MAX_SIZE = 10;
	public static int MIN_SIZE = 0;
	private int product;

	public synchronized void pruduce(){

		if(this.product>=MAX_SIZE){
			try {
				wait();
				System.out.println("盘子已满");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return;
		}

		this.product ++;
		System.out.println("生产第几个苹果:"+this.product);
		notifyAll();
	}

	public synchronized void consume(){

		if(this.product<=MIN_SIZE){
			try {
				wait();
				System.out.println("盘子为空,请等待");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return;
		}

		System.out.println("消费第几个苹果："+this.product);
		this.product--;
		notifyAll();
	}

	public void setProduct(int product) {
		this.product = product;
	}
	public int getProduct() {
		return product;
	}
}

