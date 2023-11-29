package org.example.HashTable;

import java.util.*;

public class ValidSudoku36 {
    public static void main(String[] args) {

        char[][] input= {{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

       boolean result= Solution.isValidSudoku(input);
       System.out.print(result);
    }

   public static class Solution {
        public static boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                List<Character> charV = new ArrayList<Character>();
                List<Character> charP = new ArrayList<Character>();
                for (int j = 0; j < 9; j++) {
                    if (board[i][j]!='.')
                    {
                        if (charV.contains(board[i][j]))
                            return false;
                        else charV.add(board[i][j]);
                    }
                    if (board[j][i]!='.')
                    {
                        if (charP.contains(board[j][i]))
                            return false;
                        else charP.add(board[j][i]);
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    List<Character> charSquare = new ArrayList<>();
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {
                            int x=i*3+l,y=j*3+m;

                            if (board[x][y]=='.') continue;
                            if (charSquare.contains(board[x][y]))
                                return  false;
                            else charSquare.add(board[x][y]);
                        }
                    }
                    System.out.print(charSquare);
                }
            }
            return true;
        }
    }
}
