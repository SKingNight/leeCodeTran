package enos.lee01;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：myLeecode
 * 类名：Solution
 * 描述：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那  两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 *
 * @author Administrator
 * 创建时间：2019-12-11 10:30
 **/
public class Solution {

    public static void main(String[] args) {
        int[] test = {2,7,11,15,17};
        int target = 13;
        Solution so = new Solution();
        int[] result = so.twoSum(test,target);
        System.out.println(result[0]+","+result[1]);

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> ele = new HashMap<>();
        for (int i =0;i< nums.length;i++){
            int minusR = target - nums[i];
            if (ele.containsKey(minusR)){
                result[0] = ele.get(minusR);
                result[1] = i;
                return result;
            }

            ele.put(nums[i],i);
        }

        return result;
    }
}
