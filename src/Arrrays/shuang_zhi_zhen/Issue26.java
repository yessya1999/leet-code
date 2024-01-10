package Arrrays.shuang_zhi_zhen;

/**
 * 26. 删除有序数组中的重复项
 */
public class Issue26 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Issue26().removeDuplicates(nums));
    }

    /**
     * 快慢指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums){
        int len = nums.length;

        int slow = 1;
        int fast = 1;

        while(fast < len){
            if(nums[fast] != nums[fast-1]){
                nums[slow++] = nums[fast];
            }
            fast++;
        }

        return slow;
    }
}
