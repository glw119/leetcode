package problem3;

import java.util.HashMap;

/**
 * problem3
 *
 * @author liangwu
 * @date 2019/07/31
 */
class Solution {
    // 2ms
    public int lengthOfLongestSubstring(String s) {
        int[] pos = new int[128];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = -1;
        }

        char[] cs = s.toCharArray();
        int start = 0, max = 0;
        for (int i = 0; i < cs.length; i++) {
            if (pos[cs[i]] >= start) {
                start = pos[cs[i]] + 1;
            }
            if ((i - start + 1) > max) {
                max = i - start + 1;
            }
            pos[cs[i]] = i;
        }
        return max;
    }

    // 98ms
    public int prev(String s) {
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String str = s.substring(i, j);
                max = Math.max(str.length(), max);
                if (j == len) {
                    break;
                }
                if (str.contains(String.valueOf(s.charAt(j)))) {
                    break;
                }
            }
        }
        return max;
    }

    // 7ms
    public int ppp(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }
}
