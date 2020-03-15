package com.anyu.leetcode;

/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * <p>
 * 示例 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 * <p>
 * 示例 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 * <p>
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max_area = 0;
        int row_size = grid.length;
        int col_size = grid[0].length;
        for (int row = 0; row < row_size; row++) {
            for (int col = 0; col < col_size; col++) {
                if (grid[row][col] == 1) {
                    max_area = Math.max(max_area, DFS(grid, row, col));
                }
            }
        }
        return max_area;
    }

    public int DFS(int[][] nums, int row, int col) {
        if (row < 0 || col < 0 || row > nums.length || col > nums[0].length || nums[row][col] == 0) {
            return 0;
        }
        nums[row][col] = 0;
        int area = 1;
        area += DFS(nums, row + 1, col);
        area += DFS(nums, row, col + 1);
        area += DFS(nums, row - 1, col);
        area += DFS(nums, row, col - 1);
        return area;
    }

}
