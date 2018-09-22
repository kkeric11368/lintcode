//Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1, 
//compute how much water it is able to trap after raining.

//https://lintcode-media.s3.amazonaws.com/problem/trapping-rain-water-ii.jpg

//Example
//Given 5*4 matrix
//  {
//  [12,13,0,12]
//  [13,4,13,12]
//  [13,8,10,12]
//  [12,13,12,12]
//  [13,13,13,13]
//  }
//return 14.





public class Solution {
    public int trapRainWater(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {                
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if (row < 3 || col < 3) {
            return 0;
        }

        PriorityQueue<Pair> minheap = new PriorityQueue<>();
        boolean[][] visited = new boolean[row][col];
        processBorder(matrix, visited, minheap, row, col);
        int result = 0;

        while (!minheap.isEmpty()) {
            Pair cur = minheap.poll();
            List<Pair> neighbors = allNeighbors(cur, matrix, visited);
            for (Pair nei : neighbors) {
                if (visited[nei.x][nei.y]) {
                    continue;
                }
                visited[nei.x][nei.y] = true;
                result += Math.max(cur.height - nei.height, 0);
                nei.height = Math.max(cur.height, nei.height);
                minheap.offer(nei);
            }
        }
        return result;
    }

    private void processBorder(int[][] matrix, boolean[][] visited, PriorityQueue<Pair> minheap, int row, int col) {
        for (int j = 0; j < col; j++) {
            minheap.offer(new Pair(0, j, matrix[0][j]));
            minheap.offer(new Pair(row - 1, j, matrix[row - 1][j]));
            visited[0][j] = true;
            visited[row - 1][j] = true;
        }

        for (int i = 1; i < row - 1; i++) {
            minheap.offer(new Pair(i, 0, matrix[i][0]));
            minheap.offer(new Pair(i, col - 1, matrix[i][col - 1]));
            visited[i][0] = true;
            visited[i][col - 1] = true;
        }
    }

    private List<Pair> allNeighbors(Pair cur, int[][] matrix, boolean[][] visited) {
        List<Pair> neis = new ArrayList<>();
        if (cur.x + 1 < matrix.length) {
            neis.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
        }
        if (cur.x - 1 >= 0) {
            neis.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
        }
        if (cur.y + 1 < matrix[0].length) {
            neis.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
        }
        if (cur.y - 1 >= 0) {
            neis.add(new Pair(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
        }
        return neis;
    }
}

class Pair implements Comparable<Pair> {
    int x;
    int y;
    int height;

    Pair(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    @Override
    public int compareTo(Pair another) {
        if (this.height == another.height) {
            return 0;
        }
        return this.height < another.height ? -1 : 1;
    }
}



