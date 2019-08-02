package problem5;

import java.util.*;

/**
 * problem5
 *
 * @author liangwu
 * @date 2019/08/01
 */
public class Solution {
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) >> 1);
                end = i + (len >> 1);
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String longestPalindromeOther(String s) {
        if (s.length() < 2) {
            return s;
        }
        int[] sub = new int[]{-1, -1};
        int[] pos = new int[128];
        Arrays.fill(pos, -1);
        char[] strs = s.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>(strs.length);
        for (int i = 0; i < strs.length; i++) {
            if (pos[strs[i]] == -1) {
                pos[strs[i]] = i;
                continue;
            }
            if (map.containsKey(strs[i])) {
                map.get(strs[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(pos[strs[i]]);
                list.add(i);
                map.put(strs[i], list);
            }
        }
        if (map.size() == 0) {
            return s.substring(0, 1);
        }
        boolean flag = false;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                for (int j = size - 1; j > i; j--) {
                    int count = ((list.get(j) - list.get(i)) >> 1) + 1;
                    for (int k = 1; k < count; k++) {
                        if (strs[list.get(i) + k] != strs[list.get(j) - k]) {
                            flag = false;
                            break;
                        }
                        flag = true;
                    }
                    if (flag && list.get(j) - list.get(i) > sub[1] - sub[0]) {
                        sub[1] = list.get(j);
                        sub[0] = list.get(i);
                    }
                    if (count == 1 && sub[1] - sub[0] < count) {
                        sub[1] = list.get(j);
                        sub[0] = list.get(i);
                    }
                }
            }
        }
        if (sub[0] == -1 || sub[1] == -1) {
            return s.substring(0, 1);
        }
        return s.substring(sub[0], sub[1] + 1);
    }

    public static void main(String[] args) {
        System.out.println(Solution.longestPalindrome("abccba"));
    }
}
