package leetcode_algorithm_1_20;

/**
 * 回文
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 Example:
 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example:
 Input: "cbbd"
 Output: "bb"
 * Created by wangjianjun on 2017/8/22.
 */
public class _5_Longest_Palindromic_Substring {

    StringBuilder longest = new StringBuilder("");

    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        for (int i = 0; i < s.length(); i++) {
            expand(s, longest, i, i); //odd
            expand(s, longest, i, i + 1); //even
        }

        return longest.toString();
    }

    private void expand(String s, StringBuilder longest, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                if (j - i + 1 > longest.length()) {
                    longest.delete(0, longest.length());
                    longest.append(s.substring(i, j + 1));
                }
                i--;
                j++;
            }
            else
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _5_Longest_Palindromic_Substring().longestPalindrome("cdasdfdsaes"));
    }
}
