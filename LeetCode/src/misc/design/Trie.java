package misc.design;

public class Trie {
    TrieNode root;

    class TrieNode {
        TrieNode[] nodes;
        boolean isLeaf;
        TrieNode() {
            nodes = new TrieNode[26];
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] charArray = word.toCharArray();
        TrieNode p = root; // 临时节点
        for (int i = 0; i < charArray.length; i++) {
            if (p.nodes[charArray[i] - 'a'] == null) {
                p.nodes[charArray[i] - 'a'] = new TrieNode();
            }
            p = p.nodes[charArray[i] - 'a'];
        }
        p.isLeaf = true;
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        TrieNode p = root; // 临时节点
        for (int i = 0; i < charArray.length; i++) {
            if (p.nodes[charArray[i] - 'a'] == null) {
                return false;
            }
            p = p.nodes[charArray[i] - 'a'];
        }
        return p.isLeaf;
    }

    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        TrieNode p = root; // 临时节点
        for (int i = 0; i < charArray.length; i++) {
            if (p.nodes[charArray[i] - 'a'] == null) {
                return false;
            }
            p = p.nodes[charArray[i] - 'a'];
        }
        return true;
    }
}
