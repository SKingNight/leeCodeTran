package enos.lee03;

/**
 * 项目名称：myLeecode
 * 类名：Solution
 * 描述：
 *
 * @author Administrator
 * 创建时间：
 **/
public class Solution {
    public int reverse(int x) {
        int result;
        if (x == Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            int tx = Math.abs(x);
            String tpx = String.valueOf(tx);
            StringBuilder sb = new StringBuilder(tpx);
            String tpxRev = sb.reverse().toString();
            Long ltpxRev = Long.parseLong(tpxRev);
            if (ltpxRev > Long.valueOf(Integer.MAX_VALUE)+1){
                result = 0;
            }else{
                result = -ltpxRev.intValue();
            }
        }else{
            String tpx = String.valueOf(x);
            StringBuilder sb = new StringBuilder(tpx);
            String tpxRev = sb.reverse().toString();
            Long ltpxRev = Long.parseLong(tpxRev);
            if (ltpxRev > Integer.MAX_VALUE){
                result = 0;
            }else{
                result = Integer.parseInt(tpxRev);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int tx = -2147483648;
        int ty = so.reverse(tx);
        System.out.println(ty);
    }
}
