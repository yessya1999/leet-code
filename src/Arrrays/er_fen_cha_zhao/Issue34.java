package Arrrays.er_fen_cha_zhao;

import java.util.Arrays;

/**
 * 34：在排序数组中查找元素的第一个和最后一个位置
 */
public class Issue34 {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(new Issue34().searchXFirstAndLast(nums, target)));
    }

    /**
     * 暴力破解
     * @param nums
     * @param target
     * @return
     */
    public int[] searchXFirstAndLast1(int[] nums, int target){
        int len = nums.length;

        int left = 0;
        int right = 0;

        while(left < len && nums[left] < target){
            left++;
        }
        if(left < len && nums[left] == target){
            for(right = left; right < len && nums[right] == target; right++){
            }
            return new int[]{left, right-1};
        }else{
            return new int[]{-1, -1};
        }
    }

    /**
     * 二分查找，找到最后target出现位置，向前遍历找到target区间
     * @param nums
     * @param target
     * @return
     */
    public int[] searchXFirstAndLast2(int[] nums, int target){
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        right = left - 1;
        if(right >= 0 && nums[right] == target){
            for (left = right; left >= 0; left--) {
                if(nums[left] != target){
                    break;
                }
            }
            return new int[]{left + 1, right};
        }else{
            return new int[]{-1, -1};
        }
    }

    /**
     * 暴力破解
     * @param nums
     * @param target
     * @return
     */
    public int[] searchXFirstAndLast(int[] nums, int target){
        int len = nums.length;

        int left = 0;
        int right = 0;

        while(left < len && nums[left] < target){
            left++;
        }
        if(left < len && nums[left] == target){
            for(right = left; right < len && nums[right] == target; right++){
            }
            return new int[]{left, right-1};
        }else{
            return new int[]{-1, -1};
        }
    }
}
