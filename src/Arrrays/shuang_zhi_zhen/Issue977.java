package Arrrays.shuang_zhi_zhen;

import java.util.Arrays;

/**
 * 977：有序数组的平方
 */
public class Issue977 {

    /**
     * 平方完后的数组，再进行排序
     * @param nums
     * @return
     */
    public int[] sortedSquares1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = (int) Math.pow(num, 2);
        }

        for(int epoch = 0; epoch < nums.length-1; epoch++){
            int tmp = nums[0];
            int j = 0;
            int k = nums.length;

            while(j < k){
                while(j < k && nums[k] > tmp){
                    k--;
                }
                if(j < k){
                    nums[j] = nums[k];
                }
                while(j < k && nums[j] <= tmp){
                    j++;
                }

                if(j < k){
                    nums[k] = nums[j];
                }
            }
            nums[j] = tmp;
        }

        return nums;
    }

    /**
     * 从正负之间 开始双指针向两边遍历
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums){
        int forward = -1;
        int backward = -1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                forward = i;
                break;
            }
        }
        //所有数均小于0
        if(forward == -1){
            forward = nums.length;
            backward = nums.length-1;
        }
        //所有数均大于0，backward = -1，forward = 0不用管

        //部分数小于零，部份数大于零
        if(forward > 0){
            backward = forward - 1;
        }

        int[] sortedNums = new int[nums.length];
        int idx = 0;
        while(forward < nums.length && backward >= 0){
            int num1 = Math.abs(nums[forward]);
            int num2 = Math.abs(nums[backward]);
            if(num1 < num2){
                sortedNums[idx++] = (int) Math.pow(num1, 2);
                forward++;
            }else{
                sortedNums[idx++] = (int) Math.pow(num2, 2);
                backward--;
            }
        }
        while(backward >= 0){
            sortedNums[idx++] = (int) Math.pow(nums[backward--], 2);
        }
        while(forward < nums.length){
            sortedNums[idx++] = (int) Math.pow(nums[forward++], 2);
        }
        return sortedNums;
    }

    /**
     * 双指针，两端的数平方之后一定是最大数，逆序放入返回的答案数组中
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums){
        int[] sortedNums = new int[nums.length];
        int idx = nums.length - 1;
        int first = 0;
        int last = nums.length - 1;

        while(first <= last){
            int num1 = nums[first] * nums[first];
            int num2 = nums[last] * nums[last];
            if(num1 < num2){
                sortedNums[idx--] = num2;
                last--;
            }else{
                sortedNums[idx--] = num1;
                first++;
            }
        }
        return sortedNums;
    }
}
