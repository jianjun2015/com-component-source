package leetcode_algorithm_1_20;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 * Created by wangjianjun on 2017/8/22.
 */
public class _1_Two_Sum {

    public static int[] twoSum(int[] nums,int target){

        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for (int i=0;i<nums.length;i++){
            int tmp = target - nums[i];
            if (map.containsKey(tmp)){
                if (map.get(tmp) != i){
                    return new int[]{i,map.get(tmp)};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        int target = 10;
        int[] result = twoSum(nums,target);

        if (result != null) {
            System.out.println(result[0]+"、"+result[1]);
        }
    }
}
