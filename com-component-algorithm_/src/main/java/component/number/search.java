package component.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangjianjun on 2017/7/18.
 */
public class search {

    public static void main(String[] args) {
//        findOddNumber();
//        findEvenNumber();
//        findLoseNumber();
//        findOddCountNumber();
        findEvenCountNumber();
    }

    /**
     * 需求：在1-99个数中，只有一个是奇数，请找出来
     * 解法：通过/2 或者 mod2取余
     */
    public static void findOddNumber(){

        Integer[] intArr = new Integer[]{2,4,5,6,8,22,66,44};
        if (intArr[0]%2==1){
            System.out.println(intArr[0]);
        }
        for (int i=1;i<intArr.length;i++){
            if ((intArr[i]^intArr[i-1])%2 == 1){
                System.out.println(intArr[i]);
                break;
            }
        }

    }

    /**
     * 在一批数中找偶数[只有一个偶数]
     * 解法：通过/2 或者 mod2取余
     */
    public static void findEvenNumber(){

        Integer[] intArr = new Integer[]{1,25,6,9,21,63,45};
        if (intArr[0]%2==0){
            System.out.println(intArr[0]);
        }
        for (int i=1;i<intArr.length;i++){
            if ((intArr[i]^intArr[i-1])%2 == 1){
                System.out.println(intArr[i]);
                break;
            }
        }
    }

    /**
     * 在有序连续数组中找缺少的一个数[只缺一个]
     * 解法：连续数的和减去当前数组的和  即为 缺失的数
     */
    public static void findLoseNumber(){
        Integer[] intArr = new Integer[]{1,2,3,4,5,6,8,9,10,11,12};

        int result = 0;
        for (int i=0;i<intArr.length;i++){
            result+=intArr[i];
        }

        int number = (1+12)*12/2-result;
        System.out.println(number);
    }

    /**
     * 在一批数中找只出现奇数次的一个数[都是偶数]
     * 解法：通过异或运算，所有的数逐个异或运算，偶数个的数结果均为0，最后的即为所求
     */
    public static void findOddCountNumber(){
        Integer[] intArr = new Integer[]{2,4,5,6,8,22,66,44,4,2,7,5,6,8,22,66,44,44,44,44,44};

        int result = 0;//作为异或的初始值

        for (int i=0;i<intArr.length;i++){
            result^=intArr[i];
        }

        System.out.println(result);

    }

    /**
     * 在一批数中找出现偶数次的一个数[都是奇数]
     * 解法：先对数组进行排序，然后相邻比较，相同则加一，不同则判断count，如果是偶数，则可以进行返回结果，奇数继续。
     * --扩展：按此方法可以找出所有的奇数及次数
     */
    public static void findEvenCountNumber(){
        Integer[] intArr = new Integer[]{2,4,5,6,8,22,66,44,4,4,5,4,5,4,22,6};
        Arrays.sort(intArr);
        List<Integer> result = new ArrayList<>();//如果只有一个则只需要定义整形返回即可
        int count = 1;
        for (int i=1;i<intArr.length;i++){
            if (intArr[i]==intArr[i-1]){
                count++;
            }else {
                if (count%2==0) {
                    result.add(intArr[i - 1]);
                }
                count=1;
            }
        }

        System.out.println(result);
    }
}
