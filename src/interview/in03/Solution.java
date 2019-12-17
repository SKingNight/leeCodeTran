package interview.in03;

/**
 * 项目名称：myLeecode
 * 类名：Solution
 * 描述：编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 *
 * @author Administrator
 * 创建时间：2019-12-13 13:30
 **/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        if(row == 0){
            return false;
        }

        int col = matrix[0].length;

        int sc = col-1;
        int sr = 0;

        while (sc >=0 && sr >=0 && sc < col && sr< row){
            if (matrix[sr][sc] > target){
                sc --;
            }else if (matrix[sr][sc] < target){
                sr ++;
            }else{
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] ete = {{1, 4, 7, 11, 15, 40},
                {2, 5, 8, 12, 19, 50},
                {3, 6, 9, 16, 22, 60},
                {10, 13, 14, 17, 24, 70},
                {18, 21, 23, 26, 30, 80}};


        Solution so = new Solution();
        System.out.println(so.searchMatrix(ete,40));

        System.out.println(ete[0].length);
    }
}
