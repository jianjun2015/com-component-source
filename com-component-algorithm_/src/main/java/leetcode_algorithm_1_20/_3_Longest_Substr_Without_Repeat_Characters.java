package leetcode_algorithm_1_20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *Given a string, find the length of the longest substring without repeating characters.
 Examples:
 Given "abcabcbb", the answer is "abc", which the length is 3.
 Given "bbbbb", the answer is "b", with the length of 1.
 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Created by wangjianjun on 2017/8/22.
 */
public class _3_Longest_Substr_Without_Repeat_Characters {

    public int lengthOfLongestSubstring(String s) {

        //map 用于保存各不重复字母的最新下标
        Map<Character,Integer> charMap = new HashMap<>();

        int maxLength = 0;
        int start = -1;
        int end = 0;
        for (end=0;end<s.length();end++){
            Character ch = s.charAt(end);
            if (charMap.containsKey(ch)){
                int newStart = charMap.get(ch);
                start = Math.max(start,newStart);
            }

            maxLength = Math.max(maxLength,end-start);
            charMap.put(ch,end);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new _3_Longest_Substr_Without_Repeat_Characters().lengthOfLongestSubstring("adccfhgg"));
    }
}
