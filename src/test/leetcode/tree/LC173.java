package test.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenxiangge
 * @Date 2021/3/28
 */
public class LC173 {
    private int count = 0;
    private List<Integer> res = new ArrayList<>();


    public LC173(LC094.TreeNode root) {
        if (root == null) {
            return;
        }
        //获得中序遍历列表
        inorder(root, res);

    }

    private void inorder(LC094.TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public int next() {
        int val = res.get(count);
        count++;
        return val;

    }

    public boolean hasNext() {
        return res.size() > count++;
    }
}
