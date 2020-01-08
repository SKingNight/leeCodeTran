package struct.sct05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

/**
 * 项目名称：leeCodeTran
 * 类名：Solution
 * 描述：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true

 40 41()
 91 93[]
 123 125 {}
 *
 * @author Administrator
 * 创建时间：2019-12-31 17:00
 **/
public class Solution {
    public boolean isValid(String s) {

        if (s== null || s.length() %2 != 0){
            return  false;
        }

        if (s.isEmpty() || s.trim() == ""){
            return true;
        }

        Stack<Character> sc = new Stack<>();
        for (int i =0;i< s.length();i++){
            char cr = s.charAt(i);
            if (cr == 40 || cr == 91 || cr == 123){
                sc.push(cr);
            }

            if (cr == 41 || cr == 93 || cr == 125){
                if (sc.isEmpty()){
                    return false;
                }

                char pc = sc.pop();
                if (pc -cr >2 || pc -cr < -2){
                    return false;
                }
            }

        }

        if (!sc.isEmpty()){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        String str = "(";
        System.out.println(so.isValid(str));

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sf.format(date));
    }
}
