package com.anyu.leetcode;

public class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return matrix;
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 1)
                    res[row][col] = BFS(matrix, row, col);
            }
        }
        return res;
    }

    public int BFS(int[][] matrix, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == 0) {
            return 0;
        }
        int step = 1;
        step += BFS(matrix, row, col + 1);


        int LR = Math.min(BFS(matrix, row, col + 1), BFS(matrix, row, col - 1));
        int UD = Math.min(BFS(matrix, row + 1, col), BFS(matrix, row - 1, col));
        return Math.min(LR, UD);
    }

    public static void main(String[] args) {
        UpdateMatrix updateMatrix = new UpdateMatrix();
        System.out.println(updateMatrix.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
        System.out.println(updateMatrix.updateMatrix(new int[][]{}));
        System.out.println(updateMatrix.updateMatrix(new int[][]{}));
    }
}
