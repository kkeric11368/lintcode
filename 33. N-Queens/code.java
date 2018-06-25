//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

//Given an integer n, return all distinct solutions to the n-queens puzzle.

//Each solution contains a distinct board configuration of the n-queens' placement, 
//where 'Q' and '.' both indicate a queen and an empty space respectively.

//Example
//There exist two distinct solutions to the 4-queens puzzle:
//  
//  [
//     Solution 1
//    [".Q..",
//     "...Q",
//     "Q...",
//     "..Q."
//    ],
//     Solution 2
//    ["..Q.",
//     "Q...",
//     "...Q",
//     ".Q.."
//    ]
//  ]

//Challenge
//Can you do it without recursion?



public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        
        search(results, new ArrayList<Integer>(), n);
        return results;
    }
    
    /*
     * results store all of the chessboards
     * cols store the column indices for each row
     */
    private void search(List<List<String>> results, List<Integer> cols, int n) {
        if (cols.size() == n) {
            results.add(drawChessboard(cols));
            return;
        }
        
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    
    private List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        
        return chessboard;
    }
    
    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            //排除两个Queen在同一列的情况
            if (cols.get(rowIndex) == column) {
                return false;
            }

            //排除两个Queen处于右上左下的情况            
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            
            //排除两个Queen处于左上右下的情况
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        
        return true;
    }
}

