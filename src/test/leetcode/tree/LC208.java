package test.leetcode.tree;

/**
 * @Author chenxiangge
 * @Date 4/14/21
 */
public class LC208 {
    TireNode root;

    class TireNode {
        boolean end;
        //前缀树是26叉树
        TireNode[] tires = new TireNode[26];
    }

    /**
     * Initialize your data structure here.
     */
    public LC208() {
        //初始化 头节点为空
        root = new TireNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        //从根节点开始
        TireNode now = root;
        //单字符存入
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (now.tires[index] == null) {
                //如果当前index为空，那么新建一个节点，表示当前节点有值
                now.tires[index] = new TireNode();
            }
            //循环下一个节点配置
            now = now.tires[index];
        }
        //本次insert结束
        now.end = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        //从根节点开始
        TireNode now = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            //没有当前节点数据 直接return
            if (now.tires[index] == null) {
                return false;
            }
            now = now.tires[index];
        }
        //判断当前单词是否存在，则查询到这个单词时，已经结束
        return now.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        //从根节点开始
        TireNode now = root;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            //没有当前节点数据 直接return
            if (now.tires[index] == null) {
                return false;
            }
            now = now.tires[index];
        }
        //只要判断前缀，不需要判断是否是完整单词,不需要判断return，直接return
        return true;
    }
}
