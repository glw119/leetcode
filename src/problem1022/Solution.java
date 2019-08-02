package problem1022;

/**
 * problem1022
 *
 * @author liangwu
 * @date 2019/08/02
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    private int SUM = 0;

    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
//        sumRootToLeaf(root, "0");
//        return SUM;
    }

    private int sumRootToLeaf(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum = (sum << 1) + node.val;
        return node.left == node.right ? sum : sumRootToLeaf(node.left, sum) + sumRootToLeaf(node.right, sum);
//        if (node == null) {
//            return;
//        }
//        sum += node.val;
//        if (node.left == null && node.right == null) {
//            SUM += Integer.valueOf(sum , 2);
//        } else {
//            sumRootToLeaf(node.left, sum);
//            sumRootToLeaf(node.right, sum);
//        }
    }


    public static void main(String[] args) {
        System.out.println(Integer.valueOf("1101", 2));
    }
}
