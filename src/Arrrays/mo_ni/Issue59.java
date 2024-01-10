package Arrrays.mo_ni;

/**
 * 59：旋转矩阵
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵
 */
public class Issue59 {

    public static void main(String[] args) {
        new Issue59().generateMatrix(1);
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;

        for (int i = 0; i <= n / 2 && num <= n * n; i++) {
            for(int j = i; j < n-i && num <= n * n; j++){
                matrix[i][j] = num++;
            }
            for(int j = i + 1; j < n-i && num <= n * n; j++){
                matrix[j][n-i-1] = num++;
            }
            for(int j = n-i-2; j >= i && num <= n * n; j--){
                matrix[n-i-1][j] = num++;
            }
            for(int j = n-i-2; j > i && num <= n * n; j--){
                matrix[j][i] = num++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println('\n');
        }

        return matrix;
    }
}
