package struct.sct02;

/**
 * 项目名称：leeCodeTran
 * 类名：Solution
 * 描述：岛屿数量
 *给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

 示例 1:

 输入:
 11110
 11010
 11000
 00000

 输出: 1
 示例 2:

 输入:
 11000
 11000
 00100
 00011

 输出: 3
 * @author Administrator
 * 创建时间：2019-12-26 20:30
 **/
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;
        int landNum =0;

        for(int i =0;i<rowLen;i++){
            for (int j=0;j<colLen;j++){
                if (grid[i][j] == '1'){
                    landNum++;
                    inject(grid,i,j);
                }
            }
        }

        return landNum;
    }

    private void inject(char[][] grid,int i,int j){
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if (i >= rowLen || j >= colLen || i<0 || j<0 || grid[i][j] == '0' ||  grid[i][j] =='2'){
            return;
        }

        if(grid[i][j] == '1'){
            grid[i][j] = '2';
        }

        inject(grid,i+1,j);
        inject(grid,i,j+1);
        inject(grid,i-1,j);
        inject(grid,i,j-1);

    }



    public static void main(String[] args) {
//        char[][] grid = {{'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}};
//        char[][] grid ={{'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}};
        char[][] grid ={{'1','1','1'},{'0','1','0'},{'1','1','1'}};

        Solution so = new Solution();
        int result = so.numIslands(grid);
        System.out.println(result);
    }
}
