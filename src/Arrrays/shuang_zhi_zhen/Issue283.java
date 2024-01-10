package Arrrays.shuang_zhi_zhen;

/**
 * 283：移动零：将所有 0 移动到数组的末尾
 */
public class Issue283 {

    /**
     * 双指针
     * @param nums
     */
    public void moveZeros(int[] nums){
        int len = nums.length;

        int slow = 0;
        int fast = 0;

        while(fast < len){
            if(nums[fast] != 0){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        for (int i = slow; i < len; i++) {
            nums[i] = 0;
        }
    }
}
