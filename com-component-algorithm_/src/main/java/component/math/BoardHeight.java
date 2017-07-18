package component.math;

/**
 * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
 * Created by wangjianjun on 2017/7/18.
 */
public class BoardHeight {

    public static void main(String[] args) {
        operHeight(2,100);
    }

    public static double operHeight(int count,double height){

        double s=0;
        double height_ = height;

        for (int i=0;i<count;i++){
            s+=height_;
            height_=height_/2;
            s+=height_;
        }

        System.out.println("总长度："+s);
        System.out.println("最后一次高度:"+height_);

        return s;
    }
}
