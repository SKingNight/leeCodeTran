package interview.in02;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：myLeecode
 * 类名：Solution
 * 描述：
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 示例 1:

 输入: [3,2,3]
 输出: 3
 示例 2:

 输入: [2,2,1,1,1,2,2]
 输出: 2
 *
 * @author Administrator
 * 创建时间：2019-12-13 11:00
 **/
public class Solution {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        int count = 1;
        for(int i=1;i<len;i++){
            if(count==0){
                res = nums[i];
                count++;
            }else if(nums[i]==res){
                count++;
            }else{
                count--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] test = {1,2,1,2,2,1,2};
        System.out.println(so.singleNumber(test));

    }
}
