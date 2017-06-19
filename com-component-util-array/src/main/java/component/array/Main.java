package component.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
//		String[] sqls = null; 
//		String sql = "select * from xx where v1 = ? union all select * from yy where v1=?";
//		
//		sqls = sql.split("union all ");
//		
//		System.out.println(sqls[0]);
//		System.out.println(sqls[1]);
//		
//		sql = sqls[0]+"union all "+sqls[1] +" union all ";
//		System.out.println(sql);
//		
//		System.out.println();
//		System.out.println(sql.substring(0, sql.lastIndexOf(" union all ")));
		
		User user1 = new User();
        user1.setName("a");
        user1.setOrder(1);
        User user2 = new User();
        user2.setName("b");
        user2.setOrder(2);
        List<User> list = new ArrayList<User>();
        list.add(user2);
        list.add(user1);
       
        Collections.sort(list,new Comparator<User>(){
            public int compare(User arg0, User arg1) {
                return arg0.getOrder().compareTo(arg1.getOrder());
            }
        });
        for(User u : list){
            System.out.println(u.getName());
        }
        
        (new Main()).func(1,2,3);
		
	}
	
	public void func(int... ards){
		
		for(int i=0;i<ards.length;i++){
			System.out.println(i);
		}
	}

}
