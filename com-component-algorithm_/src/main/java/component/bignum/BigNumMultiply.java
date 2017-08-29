package component.bignum;

import java.util.Arrays;

/**
 * Created by wangjianjun on 2017/8/29.
 */
public class BigNumMultiply {

    public static void main(String[] args) {
        String sa = "123456789";
        String sb = "123456789";

        char []a = sa.toCharArray();
        char []b = sb.toCharArray();

        char[] ra = reverse(a);
        char[] rb = reverse(b);

        new BigNumMultiply().multiply(ra,ra.length,rb,rb.length);

    }

    //反转数组，低位高位户掉
    public static char[] reverse(char[] src){
        char[] dst = new char[src.length];
        for (int i=0;i<src.length;i++){
            dst[i] = src[src.length-1-i];
        }

        return dst;
    }

    /**
     * 倒序数组
     * @param a
     * @param alen
     * @param b
     * @param blen
     * @return
     */
    public void multiply(char[] a,int alen,char[] b,int blen){
        //两位数的乘积位数最多不超过乘数位数和
        int csize = alen+blen+1;
        int[] c =new  int[csize];
        for (int i=0;i<c.length;i++)
            c[i] = 0;

        for (int i=0;i<alen;i++){
            for (int j=0;j<blen;j++){
                c[i+j]+=Integer.parseInt(String.valueOf(a[i]))*Integer.parseInt(String.valueOf(b[j]));
            }
        }

        int m = 0;//进位处理
        for (m=0;m<csize;m++){
            int carry = c[m]/10;
            c[m] = c[m]%10;
            if (carry>0){
                c[m+1] +=carry;
            }
        }

        //找到最高位
        for (m = csize-1;m>=0;m--){
            if (c[m]>0)
                break;
        }

        //打印乘积
        for (int n=0;n<=m;n++){
            System.out.print(c[m-n]);
        }
        System.out.println();
    }
}
