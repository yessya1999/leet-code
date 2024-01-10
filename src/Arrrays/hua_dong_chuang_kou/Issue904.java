package Arrrays.hua_dong_chuang_kou;

import java.util.HashMap;
import java.util.Map;

/**
 * 904：水果成蓝
 */
public class Issue904 {

    public static void main(String[] args) {
        int[] fruits = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(new Issue904().totalFruit(fruits));
    }

    /**
     * 滑动窗口，滑动左右边界，保证篮子中只有两种类型
     * @param fruits
     * @return
     */
    public int totalFruit1(int[] fruits) {
        //hashmap 表示篮子，篮子始终保证只有两种树类型，hashmap大小不超过2
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while(right < fruits.length){
            if(map.containsKey(fruits[right])){
                map.put(fruits[right], map.get(fruits[right]) + 1);
                right++;
            }else if(map.size() < 2){
                map.put(fruits[right], 1);
                right++;
            }else{
                if(map.get(fruits[left]) == 1){
                    map.remove(fruits[left]);
                    left++;
                }else{
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                    left++;
                }
            }
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;

    }

    /**
     * 滑动窗口优化
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < fruits.length; right++){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
