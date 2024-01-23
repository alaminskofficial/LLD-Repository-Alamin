package org.example.projects;
import java.util.*;

// You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
// Return the maximum possible length of s.
// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
// Example 1:
// Input: arr = ["un","iq","ue"]
// Output: 4
// Explanation: All the valid concatenations are:
// - ""
// - "un"
// - "iq"
// - "ue"
// - "uniq" ("un" + "iq")
// - "ique" ("iq" + "ue")
// Maximum length is 4.
// Example 2:
// Input: arr = ["cha","r","act","ers"]
// Output: 6
// Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
// Example 3:
// Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
// Output: 26
// Explanation: The only string in arr has all 26 characters.
//  Constraints:
// 1 <= arr.length <= 16
// 1 <= arr[i].length <= 26
// arr[i] contains only lowercase English letters.

public class LeetCode1239 {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("un", "iq", "ue");
        System.out.println(maxLength(arr));
    }
    public static int maxLength(List<String> arr) {
        List<Integer> arrBitSets = new ArrayList<>();
        for(String str : arr){
            strToBitSet(arrBitSets, str);
        }
        return solve(arrBitSets, 0, 0);
    }

    public static void strToBitSet(List<Integer> arrBitSets, String str) {
        int charBitSet = 0;
        for (char ch : str.toCharArray()) {
            int mask = 1 << (ch - 'a');
            if ((charBitSet & mask) != 0) return;
            charBitSet += mask;
        }
        int lenStr = str.length() << 26;
        arrBitSets.add(charBitSet + lenStr);
    }

    public static int solve(List<Integer> list, int i, int res) {
        int oldChars = res & ((1 << 26) - 1);
        int oldLen = res >> 26;
        int ans = oldLen;
        if (i >= list.size()) return ans;
        int newChars = list.get(i) & ((1 << 26) - 1);
        if ((oldChars & newChars) == 0) {
            int newLen = list.get(i) >> 26;
            int currRes = oldChars + newChars + (oldLen + newLen << 26);
            ans = Math.max(ans, solve(list, i + 1, currRes));
        }
        ans = Math.max(ans, solve(list, i + 1, res));
        return ans;
    }

}
