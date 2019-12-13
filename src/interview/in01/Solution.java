package interview.in01;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：myLeecode
 * 类名：Solution
 * 描述：
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 示例 1:

 输入: [2,2,1]
 输出: 1
 示例 2:

 输入: [4,1,2,1,2]
 输出: 4
 *
 * @author Administrator
 * 创建时间：2019-12-13 11:00
 **/
public class Solution {
    public int singleNumber(int[] nums) {
        int lenth = nums.length;
        Map<Integer,Integer> rd = new HashMap<>();
        for (int i =0;i< nums.length;i++){
            if(rd.containsKey(nums[i])){
                rd.put(nums[i],2);
            }else{
                rd.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : rd.entrySet()){
            if (entry.getValue() > lenth/2){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] test = {2,2,1};
        System.out.println(so.singleNumber(test));

    }
}
