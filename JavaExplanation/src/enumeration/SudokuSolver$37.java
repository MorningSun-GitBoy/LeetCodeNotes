package enumeration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @TimeComplexity  O(n!)
 * @SpaceComplexity O(1)
 * @Since   2020-09-15
 * @TimeOver    100%
 * @SpaceOver   69.02%
 */
public class SudokuSolver$37 {
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\SudokuSolver_37_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\SudokuSolver_37_Output"));
        while(sc.hasNext()){
            String sudokuStr = sc.nextLine();
            String compSudokuStr = so.nextLine();
        }
    }
    private static class Solution {
        private int[] line = new int[9];
        private int[] column = new int[9];
        private int[][] block = new int[3][3];
        private boolean valid = false;
        private List<int[]> spaces = new ArrayList<int[]>();

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] != '.') {
                        int digit = board[i][j] - '0' - 1;
                        flip(i, j, digit);
                    }
                }
            }

            while (true) {
                boolean modified = false;
                for (int i = 0; i < 9; ++i) {
                    for (int j = 0; j < 9; ++j) {
                        if (board[i][j] == '.') {
                            int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
                            if ((mask & (mask - 1)) == 0) {
                                int digit = Integer.bitCount(mask - 1);
                                flip(i, j, digit);
                                board[i][j] = (char) (digit + '0' + 1);
                                modified = true;
                            }
                        }
                    }
                }
                if (!modified) {
                    break;
                }
            }

            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        spaces.add(new int[]{i, j});
                    }
                }
            }

            dfs(board, 0);
        }

        public void dfs(char[][] board, int pos) {
            if (pos == spaces.size()) {
                valid = true;
                return;
            }

            int[] space = spaces.get(pos);
            int i = space[0], j = space[1];
            int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
            for (; mask != 0 && !valid; mask &= (mask - 1)) {
                int digitMask = mask & (-mask);
                int digit = Integer.bitCount(digitMask - 1);
                flip(i, j, digit);
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                flip(i, j, digit);
            }
        }

        public void flip(int i, int j, int digit) {
            line[i] ^= (1 << digit);
            column[j] ^= (1 << digit);
            block[i / 3][j / 3] ^= (1 << digit);
        }
    }
}
