package enos.lee09;

/**
 * 项目名称：myLeecode
 * 类名：Solution
 * 描述：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 *
 * @author Administrator
 * 创建时间：2019-12-12 9:00
 **/
public class Solution {

    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        StringBuilder sb = new StringBuilder(xStr);
        String reverseStrX = sb.reverse().toString();
        if (reverseStrX.equals(xStr)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Solution so = new Solution();
        System.out.println(so.isPalindrome(-121));
    }
}
