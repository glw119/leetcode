package problem2;

/**
 * problem2
 *
 * @author liangwu
 * @date 2019/07/31
 */
class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 列表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = new ListNode(0);
        ListNode root = node;
        int remaining = 0, sum = 0;
        while (l1 != null || l2 != null) {
            sum += remaining;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum > 9) {
                sum -= 10;
                remaining = 1;
            } else {
                remaining = 0;
            }
            node.next = new ListNode(sum);
            sum = 0;
            node = node.next;
        }
        if (remaining > 0) {
            node.next = new ListNode(remaining);
        }
        return root.next;
    }

    // 递归
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int ival) {
        if (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + ival;
            boolean g = sum < 10;
            ListNode node = new ListNode(g ? sum : sum - 10);
            node.next = addTwoNumbers(l1.next, l2.next, g ? 0 : 1);
            return node;
        } else if (l1 != null || l2 != null) {
            ListNode l = l1 != null ? l1 : l2;
            int sum = l.val + ival;
            boolean g = sum < 10;
            ListNode node = new ListNode(g ? sum : sum - 10);
            node.next = addTwoNumbers(l.next, null, g ? 0 : 1);
            return node;
        } else {
            return ival > 0 ? new ListNode(ival) : null;
        }
    }
}
