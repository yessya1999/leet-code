package Arrrays.er_fen_cha_zhao;

/**
 * 704：二分查找
 */
public class Issue704 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;

        Issue704 issue704 = new Issue704();
        System.out.println(issue704.search(nums, target));
    }

    /**
     * 区间左闭右闭：[left, right]
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target){
        int len = nums.length;
        if(len == 0){
            return -1;
        }

        for(int left = 0, right = len-1; left <= right;){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 区间左闭右开：[left, right)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target){
        int len = nums.length;
        if(len == 0){
            return -1;
        }

        int left = 0;
        int right = len - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right= mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }

        return -1;
    }
}
