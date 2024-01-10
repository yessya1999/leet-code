package Arrrays.mo_ni;

import java.util.ArrayList;
import java.util.List;

/**
 * 54：螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
 */
public class Issue54 {

    public static void main(String[] args) {

    }


    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int l = matrix[0].length;
        int count = 1;
        int start = 0;
        List<Integer> list = new ArrayList<>();
        int nums = r * l;

        while(start < r/2 && start < l/2){
            for(int j = start; j < l - start - 1; j++){
                list.add(matrix[start][j]);
            }
            for(int i = start; i < r - start - 1; i++){
                list.add(matrix[i][l - start - 1]);
            }
            for(int j = l - start - 1; j > start; j--){
                list.add(matrix[r - start - 1][j]);
            }
            for(int i = r - start - 1; i > start; i--){
                list.add(matrix[i][start]);
            }
            start++;
        }
        if(r <= l && r % 2 == 1){
            for(int j = start; j < l - start; j++){
                list.add(matrix[start][j]);
            }
        }
        if(l < r && l % 2 == 1){
            for(int i = start; i < r - start; i++){
                list.add(matrix[i][start]);
            }
        }
        return list;
    }
}
