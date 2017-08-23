package leetcode_algorithm_1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Created by wangjianjun on 2017/8/22.
 */
public class _4_Median_Of_Sorted_Array {

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }

    public double findMedianSortedArrays_(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,result,0,nums1.length);
        System.arraycopy(nums2,0,result,nums1.length,nums2.length);

        Arrays.sort(result);

        if (result.length%2==0){
            return (result[result.length/2-1]+result[result.length/2])/2.0;
        }else {
            return result[result.length/2];
        }
    }

    public static void main(String[] args) {
        System.out.println(new _4_Median_Of_Sorted_Array().findMedianSortedArrays_(new int[]{1,3},new int[]{2,4}));
    }
}
