package component.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangjianjun on 2017/7/18.
 */
public class Swap {

    public static void main(String[] args) {
//        swap("start","end");
//        swap_number(1,2);
//        swap_number_(1,2);
//        lib_reverse();
        lib_reverse_();
    }

    /**
     * 普通方式
     * @param obj_start
     * @param obj_end
     */
    public static void swap(Object obj_start,Object obj_end){
        Object tmp = obj_start;
        obj_start = obj_end;
        obj_end = tmp;

        System.out.println(obj_start+":"+obj_end);
    }

    /**
     * 数字类型 通过加法
     * @param start
     * @param end
     */
    public static void swap_number(Integer start,Integer end){
        start += end;
        end = start-end;
        start = start-end;

        System.out.println(start+":"+end);
    }

    /**
     * 数字类型 通过乘法
     * @param start
     * @param end
     */
    public static void swap_number_(Integer start,Integer end){
        start *= end;
        end = start/end;
        start = start/end;

        System.out.println(start+":"+end);
    }

    public static void lib_reverse(){
        List arrayList = Arrays.asList("A","B","C","D","E");
//        arrayList.add("A");
//        arrayList.add("B");
//        arrayList.add("C");
//        arrayList.add("D");
//        arrayList.add("E");
        System.out.println("Before Reverse Order: " + arrayList);
        Collections.reverse(arrayList);
        System.out.println("After Reverse Order: " + arrayList);
    }

    public static void lib_reverse_(){

//        String str2 = "1234567";
//        char[] arr = str2.toCharArray();

        List arrayList = Arrays.asList('A','B','C','D','E');
//        List arrayList = Arrays.asList('A','B','C','D','E');
//        arrayList.add("A");
//        arrayList.add("B");
//        arrayList.add("C");
//        arrayList.add("D");
//        arrayList.add("E");
        System.out.println("Before Reverse Order: " + arrayList);
        Collections.reverse(arrayList);
        System.out.println("After Reverse Order: " + arrayList);
    }
}
