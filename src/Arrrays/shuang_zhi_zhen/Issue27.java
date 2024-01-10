package Arrrays.shuang_zhi_zhen;

/**
 * 27：移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 */
public class Issue27 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(new Issue27().removeElement(nums, val));
    }

    /**
     * 快慢指针：将 后面指针的数字移动到 前面指针的空位
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[idx++] = nums[i];
            }
        }

        return idx;
    }

    /**
     * 双向指针：相当于 快指针从数组末尾开始向前遍历
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        int right = nums.length - 1;

        while(idx <= right){
            if(nums[idx] == val){
                nums[idx] = nums[right];
                right--;
            }else{
                idx++;
            }
        }

        return idx;
    }
}
