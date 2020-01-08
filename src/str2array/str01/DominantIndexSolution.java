package str2array.str01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 项目名称：leeCodeTran
 * 类名：DominantIndexSolution
 * 描述：至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。

 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。

 如果是，则返回最大元素的索引，否则返回-1。

 示例 1:

 输入: nums = [3, 6, 1, 0]
 输出: 1
 解释: 6是最大的整数, 对于数组中的其他整数,
 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.


 示例 2:

 输入: nums = [1, 2, 3, 4]
 输出: -1
 解释: 4没有超过3的两倍大, 所以我们返回 -1.


 提示:

 1.nums 的长度范围在[1, 50].
 2.每个 nums[i] 的整数范围在 [0, 100].
 *
 *
 * @author Administrator
 * 创建时间：2020-01-08 19:39
 **/
public class DominantIndexSolution {

    public int dominantIndex(int[] nums) {

        if(nums == null){
            return -1;
        }

        if (nums.length == 1){
            return 0;
        }

        List<Integer> tmp = new ArrayList<>();
        Map<Integer,Integer> valueIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            valueIndex.put(nums[i],i);
            tmp.add(nums[i]);
        }
        tmp.sort(Integer::compareTo);
        if (tmp.get(nums.length-1) >= tmp.get(nums.length-2) * 2){
            return valueIndex.get(tmp.get(nums.length-1));

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        DominantIndexSolution so = new DominantIndexSolution();
        System.out.println(so.dominantIndex(nums));
    }
}
