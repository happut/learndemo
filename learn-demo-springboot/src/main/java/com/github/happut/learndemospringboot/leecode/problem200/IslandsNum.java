package com.github.happut.learndemospringboot.leecode.problem200;

import java.util.List;

public class IslandsNum {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        IslandsNum islandsNum = new IslandsNum();
        System.out.println(islandsNum.numIslands(grid));
    }

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count += floodfill_DFS(grid, i, j);
            }
        }


        return count;
    }

    public int floodfill_DFS(char[][] grid, int i, int j) {
        if(i<0||i==grid.length){
            return 0;
        }

        if(j<0||j==grid[i].length){
            return 0;
        }

        if(grid[i][j] == '0'){
            return 0;
        }

        grid[i][j] = '0';
        floodfill_DFS(grid,i-1,j);
        floodfill_DFS(grid,i+1,j);
        floodfill_DFS(grid,i,j-1);
        floodfill_DFS(grid,i,j+1);
        return 1;
    }
}
