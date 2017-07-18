package component.string;

/**
 * 有序数组合并为有序数组
 * --扩展：可以选择去重
 * Created by wangjianjun on 2017/7/18.
 */
public class StringConbianation {

    public static void main(String[] args) {

        char[] str1 = new char[]{'a','b','f','g','h'};
        char[] str2 = new char[]{'c','d','e','i','k','l'};

        conbination(str1,str2);
    }

    public static void conbination(char[] str1,char[]str2){

        int index_i = 0;
        int index_j = 0;
        int index_k = 0;
        char[] str = new char[str1.length+str2.length+1];
        while (index_i<str1.length && index_j<str2.length){
            if (str1[index_i]<str2[index_j]){
                str[index_k++] = str1[index_i++];
            }else if (str1[index_i]>str2[index_j]){
                str[index_k++]=str2[index_j++];
            }//去重
            else {
                str[index_k++] = str1[index_i++];
                index_j++;
            }
        }

        while (index_i<str1.length){
            str[index_k++] = str1[index_i++];
        }

        while (index_j<str2.length){
            str[index_k++]=str2[index_j++];
        }

        System.out.println(str);
    }
}
