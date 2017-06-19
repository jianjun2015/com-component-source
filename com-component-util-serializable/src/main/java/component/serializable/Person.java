package component.serializable;

import java.io.Serializable;

public class Person implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 783117108287026737L;
	
	private String name;
	private Integer age;
	transient private String cardNo;//˲ʱ�������η�
	static String defaultValue = "XXXX";
	
	public static void setDefaultValue(String defaultValue) {
		Person.defaultValue = defaultValue;
	}
	
	public static String getDefaultValue() {
		return defaultValue;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public String getCardNo() {
		return cardNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	
	public Person(String name, Integer age, String cardNo) {
		super();
		this.name = name;
		this.age = age;
		this.cardNo = cardNo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+":"+this.age+":"+this.cardNo;
	}

}
