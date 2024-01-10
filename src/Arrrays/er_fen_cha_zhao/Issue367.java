package Arrrays.er_fen_cha_zhao;

/**
 * 367：有效的完全平方数
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 */
public class Issue367 {

    public static void main(String[] args) {
        System.out.println(new Issue367().isPerfectSquare(42));
    }

    /**
     * 二分查找
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        int left = 1;
        int right = num;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if((long) mid * mid > num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(Math.pow(left -1, 2) == num){
            return true;
        }
        return false;
    }

    /**
     * 对数变换
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int x0 = (int) Math.exp(0.5 * Math.log(num));
        if((long)Math.pow(x0, 2) == num || (long)Math.pow(x0+1, 2) == num){
            return true;
        }
        return false;
    }
}
