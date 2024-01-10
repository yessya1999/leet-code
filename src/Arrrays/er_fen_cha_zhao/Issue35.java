package Arrrays.er_fen_cha_zhao;

/**
 * 35：搜索插入位置
 */
public class Issue35 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 2;

        Issue35 issue35 = new Issue35();
        System.out.println(issue35.searchInsertIdx(nums, target));
    }

    /**
     * 左闭右闭 [left, right]时，如果不存在当前元素，最终nums[right] < target < nums[left]，一定会插在left位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertIdx1(int[] nums, int target){
        int left = 0;
        int right = nums.length;

        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] > target){
                right -= 1;
            }else if(nums[mid] < target){
                left += 1;
            }else{
                return mid;
            }
        }

        return left;
    }

    /**
     * 左闭右开 [left, right)时，如果不存在当前元素，最终nums[right] = nums[left] < target，一定会插在left位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertIdx(int[] nums, int target){
        int left = 0;
        int right = nums.length;

        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] > target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }

        return left;
    }
}
