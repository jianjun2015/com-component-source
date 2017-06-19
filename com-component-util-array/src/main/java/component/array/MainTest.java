package component.array;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {
	
	public static void main(String[] args) {
		
		String o1 = "qi.qw";

		System.out.println(o1.indexOf('.'));
		System.out.println(o1.length());
		System.out.println(o1.substring(o1.indexOf('.')+1, o1.length()));
		
		System.out.println(o1.concat("0"));
		
		fun();
		
	}
	
	public static void fun() {  
        System.out.println(isNumber1("+001"));  
        System.out.println(isNumber2("+1001"));  
  
    }  
  
    /** 
     * ʹ���ַ�����matches���� 
     *  
     * @param s 
     * @return 
     */  
    public static int isNumber1(String s) {  
  
        String regex = "^[1-9][0-9]*\\.[0-9]+$|^[1-9][0-9]*$|^0+\\.[0-9]+$";  
        char c = s.charAt(0);  
        boolean bool;  
        if (c == '+' | c == '-') {  
            bool = s.substring(1).matches(regex);  
        } else {  
            bool = s.matches(regex);  
        }  
        if (bool) {  
            return 1;  
        } else {  
            return 0;  
        }  
    }  
  
    /** 
     * ʹ��Pattern��Matcher��ķ��� 
     *  
     * @param s 
     * @return 
     */  
    public static int isNumber2(String s) {  
  
        String regex = "^[1-9][0-9]*\\.[0-9]+$|^[1-9][0-9]*$|^0+\\.[0-9]+$";  
        Pattern pattern = Pattern.compile(regex);  
        char c = s.charAt(0);  
        if (c == '+' || c == '-') {  
            s = s.substring(1);  
        }  
        Matcher matcher = pattern.matcher(s);  
        boolean bool = matcher.matches();  
        if (bool) {  
            return 1;  
        } else {  
            return 0;  
        }  
    }  

}
