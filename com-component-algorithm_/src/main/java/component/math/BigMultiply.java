package component.math;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangjianjun on 2017/7/18.
 */
public class BigMultiply {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // System.out.println("Hello world");

        String str1 = "1234567";
        String str2 = "1234567";
//        String str1 = "1076060999";
//        String str2 = "90188905567";
//        String str1 = "23456789009877666555544444";
//        String str2 = "346587436598437594375943875943875";

        int len1 = str1.length();
        int len2 = str2.length();

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        // 高低位对调  乘法由地位算起，所以对调之后可以顺序遍历计算
        covertdata(s1, len1);
        covertdata(s2, len2);

        System.out.println("乘数："+str1);
        System.out.println("乘数："+str2);
        multiply(s1, len1, s2, len2);

        //运用java类库 取巧方式
        /*
        BigInteger a = new BigInteger(str1);
        BigInteger b = new BigInteger(str2);
        BigInteger c = a.multiply(b);
        System.out.println("乘积："+c);
        */

    }

    public static void covertdata(char data[], int len) {
        //高低位对调
        for (int i = 0; i < len / 2; i++) {
            data[i] += data[len - 1 - i];
            data[len - 1 - i] = (char) (data[i] - data[len - 1 - i]);
            data[i] = (char) (data[i] - data[len - 1 - i]);
        }
    }

    public static void multiply(char a[], int alen, char b[], int blen) {
        // 两数乘积位数不会超过乘数位数和+ 3位
        int csize = alen + blen + 3;
        // 开辟乘积数组
        int[] c = new int[csize];
        // 乘积数组填充0
        for (int ii = 0; ii < csize; ii++) {
            c[ii] = 0;
        }
        // 对齐逐位相乘
        for (int j = 0; j < blen; j++) {
            for (int i = 0; i < alen; i++) {
                c[i + j] +=  Integer.parseInt(String.valueOf(a[i]))* Integer.parseInt(String.valueOf(b[j]));
            }
        }
        int m = 0;
        // 进位处理
        for (m = 0; m < csize; m++) {
            int carry = c[m] / 10;
            c[m] = c[m] % 10;
            if (carry > 0)
                c[m + 1] += carry;
        }
        // 找到最高位
        for (m = csize - 1; m >= 0;) {
            if (c[m] > 0)
                break;
            m--;
        }
        // 由最高位开始打印乘积
        System.out.print("乘积：");
        for (int n = 0; n <= m; n++) {
            System.out.print(c[m - n]);
        }
        System.out.println("");
    }
}
