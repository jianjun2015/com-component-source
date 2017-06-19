package component.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	
	public static void main(String[] args) {
		
		Util util = new Util();
		System.out.println(util.isNumber("123123"));
		System.out.println(util.isNumber("00123.123"));
		System.out.println(util.isNumber("0123123"));
		System.out.println(util.isNumber("0"));
		System.out.println(util.isNumber("0.12"));
		
		System.out.println(util.getDouble("123"));
		System.out.println(util.getDouble("123.0000"));
		System.out.println(util.getDouble("00123.12222000"));
	}
	
	public boolean isNumber(String str){
		
		Pattern pattern = Pattern.compile(""
				+ "^\\+?[1-9][0-9]*$|"
				+ "^0$|"
				+ "^[1-9][0-9]*\\.[0-9]+$|"
				+ "^[0-9]\\.[0-9]+$|");
		Matcher isNum = pattern.matcher(str);
		if(isNum.matches()){
			return true;
		}else {
			return false;
		}
	}
	
	public Double getDouble(String str){
		
		Double double_1 = Double.valueOf(str);
		
		return double_1;
	}

}
