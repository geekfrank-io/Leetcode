package org.example.DFS;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver37 {
    public static void main(String[] args) {

        char[][] input = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


        Solution.SolveSudokuSo(input);
    }

    public static class Solution {
       static  boolean[][] charLine = new boolean[9][9];
        static boolean[][] charColumn = new boolean[9][9];
        static boolean[][][] charBlock = new boolean[3][3][9];
        static boolean isValid = false;
        static List<int[]> spaces = new ArrayList<int[]>();

        public static void SolveSudokuSo(char[][] board) {


            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char var = board[i][j];
                    if (var == '.') {
                        spaces.add(new int[]{i, j});
                    } else {
                        int val = var - '0' - 1;
                        charLine[i][val] = true;
                        charColumn[j][val] = true;
                        charBlock[i / 3][j / 3][val] = true;
                    }
                }
            }
            dfs(board,0);

        }

        public static void dfs(char[][] board, int position) {
            if (position == spaces.size()) {
                isValid = true;
                return;
            }
            int[] space=spaces.get(position);
            int i=space[0],j=space[1];
            for (int num=0;num<9&&!isValid;num++)
            {
                if (!charLine[i][num]&&!charColumn[j][num]&&!charBlock[i/3][j/3][num]){
                    charLine[i][num]=charColumn[j][num]=charBlock[i/3][j/3][num]=true;
                    board[i][j]=(char)(num+'0'+1);
                    dfs(board,position+1);
                    charLine[i][num]=charColumn[j][num]=charBlock[i/3][j/3][num]=false;

                }
            }
        }


    }
}
