package str2array.str01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：leeCodeTran
 * 类名：PivotIndexSolution
 * 描述：寻找数组的中心索引
 *给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。

 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

 示例 1:

 输入:
 nums = [1,7,3,6,5,6]
 输出: 3
 解释:
 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 同时,3 也是第一个符合要求的中心索引。
 示例 2:

 输入:
 nums = [1,2,3]
 输出: -1
 解释:
 数组中不存在满足此条件的中心索引。
 说明:

 nums 的长度范围为 [0,10000]。
 任何一个 nums[i] 将会是一个范围在 [-1000,1000]的整数。
 * @author Administrator
 * 创建时间：2020-01-08 15:40
 **/
public class PivotIndexSolution {
    public int pivotIndex(int[] nums) {
        // 数组为null或者长度小于3都没有中心位置
        if (nums != null){
            if ( nums.length == 1){
                return 0;
            }
            int len = nums.length;
            Map<Integer,String> rightValesIndex = new HashMap<>();
            int tmp=0 ;
            for (int j = len-1; j >= 0 ; j--) {
                tmp += nums[j];
                if (rightValesIndex.containsKey(tmp)){
                    rightValesIndex.put(tmp,rightValesIndex.get(tmp)+","+j);
                }else{
                    rightValesIndex.put(tmp,String.valueOf(j));
                }


            }

            if(rightValesIndex.containsKey(0) && Arrays.asList(rightValesIndex.get(0).split(",")).contains(String.valueOf(1))){
                return 0;
            }

            tmp = 0;
            for (int i = 0; i < len-1; i++) {
                tmp += nums[i];
                if(rightValesIndex.containsKey(tmp)){
                    for(String rightIndex:rightValesIndex.get(tmp).split(",")){
                        if (Integer.parseInt(rightIndex) - i == 2 ){
                            return i+1;
                        }
                        if ( Integer.parseInt(rightIndex) == i){
                            return i;
                        }
                    }

                }

                if (tmp == 0 && i == len -2){
                    return i+1;
                }
            }



        }
        return -1;
    }


    /**
     * @Author Wanghui
     * @Description
     * 正确姿势哎，无法言语
     * 某个数的左右边和相等，为2*X，加上当前位置的数为所有数的和
     * 反过来讲，和减去当前位置的数，得到的是左边数和的两倍，表示位置就找到了。
     * 位置的左偏移和右偏移的区别就在于从左边遍历还是从右边遍历。
     *
     * 顺题目的思路写了一大摞代码，消耗内存无数猜得到答案，不如先分析题目抽象成数学问题然后求解
     * @Date 16:59 2020/1/8 0008
     * @Param [nums]
     * @return int
     **/
    public int pivotIndex_fix(int[] nums) {
        int sum = 0,leftSum = 0;
        for(int num:nums){
            sum+=num;
        }
        for(int i=0;i<nums.length;i++){
            if(sum -nums[i] == leftSum*2){
                return i;
            }else{
                leftSum += nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums ={-1,-1,0,1,1,0};
        PivotIndexSolution so = new PivotIndexSolution();
        System.out.println(so.pivotIndex(null));
    }
}
