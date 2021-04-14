package test.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenxiangge
 * @Date 4/13/21
 */
public class LC783 {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //二叉搜索树，中序遍历，可以获得一个有序的数组
        //递归中序遍历 左根右
        mid(root, list);

        int min = list.get(1) - list.get(0);
        //获取数组中的差值的最小值-已经有序，按需查询即可
        for (int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i + 1) - list.get(i);
            if (min > temp) {
                min = Math.min(temp, min);

            }
        }
        return min;
    }

    private void mid(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        mid(root.left, list);
        list.add(root.val);
        mid(root.right, list);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
