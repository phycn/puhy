package cn.puhy.leetcode.array;

/**
 * @author puhongyu
 * 2018/8/9 16:16
 */
public class DiagonalTraversal {
    public int[] findDiagonalOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int max = m > n ? m : n;

        int x = 0;
        int y = 0;
        for (int i = 0; i < max; i++) {
            while ((x >= 0 && x < m) && (y >= 0 && y < n)) {
                System.out.println(matrix[x++][y++]);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[][] arr = {{2, 5}, {1, 3}, {3, 2}, {1, 7}};
        System.out.println(arr.length);
    }
}
