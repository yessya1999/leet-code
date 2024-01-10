package Arrrays.er_fen_cha_zhao;

/**
 * 69：计算x的算数平方根
 */
public class Issue69 {

    public static void main(String[] args) {
        System.out.println(new Issue69().mySqrt(2147395600));
    }

    public int mySqrt1(int x) {
        if(x == 0){
            return 0;
        }
        int i = 0;
        long i2 = 0;
        while(i2 <= x){
            i++;
            i2 = (long) i * i;
        }
        return i - 1;
    }

    public int mySqrt2(int x) {
        if(x == 0){
            return 0;
        }
        int i = 1;
        while(x / i >= i){
            i++;
        }
        return i - 1;
    }

    public int mySqrt(int x){
        int left = 0;
        int right = x;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if((long) mid * mid > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
