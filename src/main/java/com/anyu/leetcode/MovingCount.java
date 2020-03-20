package com.anyu.leetcode;

public class MovingCount {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return BFS(0, 0, m, n, k, visited);
    }

    public int BFS(int row, int col, int m, int n, int k, boolean[][] visited) {
        if (row < 0 || row > m || col < 0 || col > n || k < (row / 10 + row % 10 + col / 10 + col % 10) || visited[row][col])
            return 0;
        visited[row][col] = true;
        return BFS(row, col - 1, m, n, k, visited) + BFS(row - 1, col, m, n, k, visited)
                + BFS(row + 1, col, m, n, k, visited) + BFS(row, col + 1, m, n, k, visited) + 1;
    }
}
