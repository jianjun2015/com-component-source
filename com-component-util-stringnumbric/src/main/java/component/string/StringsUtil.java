package component.string;

import org.apache.commons.lang.StringUtils;

public class StringsUtil {

	public static String upperFirst(String str){
		if (str != null){
			if (str.length() == 1){
				return StringUtils.upperCase(str);
			}else {
				return StringUtils.upperCase(str.substring(0,1))+
						str.substring(1);
			}
		}
		return null;
	}

	public static void main(String[] args) {

//		String Str = new String("www?google??com");
//
//		System.out.print("匹配成功返回值 :" );
//		System.out.println(Str.replaceAll("(.*)google(.*)",
//                            "runoob" ));
//		System.out.print("匹配失败返回值 :" );
//		System.out.println(Str.replaceAll("(.*)taobao(.*)",
//                            "runoob" ));
//		
//		System.out.println(Str.replaceFirst("\\?", "XX"));
//		System.out.println(Str.replaceFirst("\\?\\?", "XX"));

		String ss = "select t.plan_name,t.plan_type,t.cron,t.plan_status,t.ref_check_name from t_ins_check_plan t WHERE t.plan_type = ? and t.cron = ? limit 2";
		String s = ss.replace("?", "XXXX");
		System.out.println(s);

		System.out.println(upperFirst("abcde"));
	}

}
