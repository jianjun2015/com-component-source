package component.util;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class Exchange {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
