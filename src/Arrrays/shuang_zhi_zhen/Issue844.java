package Arrrays.shuang_zhi_zhen;

/**
 * 844：比较含退格的字符串
 */
public class Issue844 {
    public static void main(String[] args) {
        String s = "a##c";
        String t = "#a#c";
        System.out.println(new Issue844().backspaceCompare(s, t));
    }

    /**
     * 经过退格处理过后的字符串进行比较
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t){
        String s1 = removeBackspace(s);
        String s2 = removeBackspace(t);
//        System.out.println(s1 + "  " + s2);
        return s1.equals(s2);
    }

    /**
     * 通过双指针实现消除字符串中退格的功能
     * @param str
     * @return
     */
    public String removeBackspace(String str){
        int len = str.length();
        if(len == 0 || (len == 1 &&str.charAt(0) == '#')){
            return "";
        }

        int slow = 0;
        int fast = 0;
        char[] chars = str.toCharArray();
        while(fast < len){
            //注意slow必须>0，防止“##”情况时的溢出错误
            if(chars[fast] == '#' && slow > 0){
                slow--;
            }else if(chars[fast] != '#'){
                chars[slow++] = chars[fast];
            }
            fast++;
        }
        return new String(chars).substring(0, slow);
    }
}
