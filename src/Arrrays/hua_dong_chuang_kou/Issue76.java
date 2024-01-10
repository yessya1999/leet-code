package Arrrays.hua_dong_chuang_kou;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 76：最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串
 */
public class Issue76 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new Issue76().minWindow(s, t));
    }

    public String minWindow(String s, String t){
        int maxL = 0;
        int maxR = Integer.MAX_VALUE;
        int left = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(int right = 0; right < s.length(); right++){
            if (tMap.containsKey(s.charAt(right))) {
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            if(check(sMap, tMap) && left <= right){
                if(tMap.containsKey(s.charAt(left))){
                    if((right - left) < (maxR - maxL)){
                        maxR = right;
                        maxL = left;
                    }
                    sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0) - 1);
                    left++;
                }

                while(left <= right && tMap.containsKey(s.charAt(++left))){
                }
            }
        }

        return (maxR == Integer.MAX_VALUE) ? "" : s.substring(maxL, maxR + 1);
    }

    public boolean check(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        Iterator<Map.Entry<Character, Integer>> iterator = tMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Character, Integer> entry = iterator.next();
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if(sMap.getOrDefault(key, 0) < val){
                return false;
            }
        }
        return true;
    }

    public String minWindow2(String s, String t){
        int maxL = 0;
        int maxR = 0;
        int left = 0;
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = tMap.size();

        for(int right = 0; right < s.length(); right++){
            if(tMap.get(s.charAt(right)) != null){
                tMap.put(s.charAt(right), tMap.get(s.charAt(right)) - 1);
                if(tMap.get(s.charAt(right)) == 0){
                    count--;
                }
            }


            while(count == 0 && left <= right){

                if(tMap.get(s.charAt(left)) != null){
                    if((right - left) > (maxR - maxL)){
                        maxR = right;
                        maxL = left;
                    }

                    tMap.put(s.charAt(left), tMap.get(s.charAt(left)) + 1);
                    if(tMap.get(s.charAt(left)) > 0){
                        count++;
                    }
                }
                left++;
            }

        }
        return s.substring(maxL, maxR + 1);
    }

    public String minWindow1(String s, String t) {
        int maxL = 0;
        int maxR = 0;
        int left = 0;
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = tMap.size();

        while(left < s.length() && tMap.get(s.charAt(left)) == null){
            left++;
        }

        for(int right = left; right < s.length(); right++){
            if(tMap.get(s.charAt(right)) != null){
                tMap.put(s.charAt(right), tMap.get(s.charAt(right)) - 1);
                if(tMap.get(s.charAt(right)) == 0){
                    count--;
                }
            }
            while(count == 0){
                if((right - left) > (maxR - maxL)){
                    maxR = right;
                    maxL = left;
                }
                Integer tmp = tMap.get(s.charAt(left));
                left++;
                if(tmp == null){
                    continue;
                }
                tMap.put(s.charAt(left-1), tmp + 1);
            }

            while(left < s.length() && tMap.get(s.charAt(left)) == null){
                left++;
            }
        }

        return s.substring(maxL, maxR + 1);
    }
}
