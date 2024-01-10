package Arrrays.hua_dong_chuang_kou;

/**
 * 209：长度最小的子数组
 */
public class Issue209 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(new Issue209().minSubArrayLen(target, nums));
    }

    /**
     * 滑动窗口：就是不断的调节⼦序列的起始位置和终⽌位置，从⽽得出我们要想的结果
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int target, int[] nums){
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;

        while(left < nums.length){
            if(right < nums.length && sum < target){
                sum += nums[right];
                right++;
            }else{
                sum -= nums[left];
                left++;
            }
            if(sum >= target && minLen > (right - left)){
                minLen = right - left;
            }
        }
        if(minLen == Integer.MAX_VALUE){
            minLen = 0;
        }

        return minLen;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;

        while(right < nums.length){
            sum += nums[right];
            while(sum >= target){
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if(minLen == Integer.MAX_VALUE){
            minLen = 0;
        }

        return minLen;
    }
}
