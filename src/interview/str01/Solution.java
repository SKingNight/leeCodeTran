package interview.str01;

import sun.misc.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 项目名称：leeCodeTran
 * 类名：Solution
 * 描述：
 *给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false
 * @author Administrator
 * 创建时间：2019-12-16 16:00
 **/
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null){
            return false;
        }

        if (s == ""){
            return true;
        }

        String des = s.replaceAll("[^a-zA-Z0-9]", "");
        // 1.使用StringBuilder的反转函数
        // 2.可以全小写后从前后各逐位匹配
        StringBuilder sb = new StringBuilder(des);
        StringBuilder rRdes = sb.reverse();
        if (des.equalsIgnoreCase(rRdes.toString())){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // 1.正则筛出字符串和数字

        Solution so = new Solution();
        String test = "Damosel, a poem? A carol? Or a cameo pale? (So mad!)";
        System.out.println(so.isPalindrome(test));
    }
}
