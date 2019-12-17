package interview.in04;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目名称：leeCodeTran
 * 类名：Solution
 * 描述：给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]
 *
 * @author Administrator
 * 创建时间：2019-12-16 9:00
 **/
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < m+n){
            return;
        }

        List<Integer> list1 = Arrays.stream( nums1 ).limit(m).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream( nums2 ).limit(n).boxed().collect(Collectors.toList());
        list1.addAll(list2);
        list1.sort(Integer::compareTo);
        for (int i = 0; i < list1.size(); i++) {
            nums1[i] = list1.get(i);
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        Solution so = new Solution();
        so.merge(nums1,3,nums2,3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }

    }
}
