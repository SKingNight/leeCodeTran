package str2array.str01;

/**
 * 项目名称：leeCodeTran
 * 类名：PlusOneSolution
 * 描述：加一
 *给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。
 * @author Administrator
 * 创建时间：2020-01-08 20:08
 **/
public class PlusOneSolution {
    public int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0){
            return new int[]{1};
        }
        int len = digits.length;
        addSelf(digits,len-1);
        if (digits[0] >= 10){
            int[] result = new int[len+1];
            System.arraycopy(digits,1,result,2,len-1);
            result[0] = 1;
            result[1] = 0;
            return result;
        }

        return digits;
    }

    private void addSelf(int[] digits,int i){
        if (i == 0 || digits[i]+1 < 10){
            digits[i] = digits[i]+1;
            return ;
        }
        digits[i] = 0;
        addSelf(digits,i-1);
    }

    public static void main(String[] args) {
        int[] num = {9};
        PlusOneSolution so = new PlusOneSolution();

        for (int ele : so.plusOne(num)){
            System.out.println(ele);
        }
        System.out.println();
    }
}
