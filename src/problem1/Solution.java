package problem1;

import java.util.HashMap;
import java.util.Map;

/**
 * problem1
 *
 * @author liangwu
 * @date 2019/07/31
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++){
            int a = nums[i];
            Integer pos = map.get(a);
            if (pos == null){
                map.put(target - a, i);
            } else {
                return new int[] {pos, i};
            }
        }
        return new int[]{};
    }
}