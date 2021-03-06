package misc.huisu;

import annotations.HuiSu;

import java.util.LinkedList;
import java.util.List;


/**回溯题型：
 * 一、排列、组合、子集
 * 46. 全排列（中等）
 * 47. 全排列 II（中等）：思考为什么造成了重复，如何在搜索之前就判断这一支会产生重复；
 * 39. 组合总和（中等）
 * 40. 组合总和 II（中等）
 * 77. 组合（中等）
 * 78. 子集（中等）
 * 90. 子集 II（中等）：剪枝技巧同 47 题、39 题、40 题；
 * 60. 第 k 个排列（中等）：利用了剪枝的思想，减去了大量枝叶，直接来到需要的叶子结点；
 * 93. 复原 IP 地址（中等）
 *
 * 二、Flood Fill
 * 733. 图像渲染（Flood Fill，中等）
 * 200. 岛屿数量（中等）
 * 130. 被围绕的区域（中等）
 * 79. 单词搜索（中等）
 *
 * 三、字符串中的回溯问题
 * 17. 电话号码的字母组合（中等），题解；
 * 784. 字母大小写全排列（中等）；
 * 22. 括号生成（中等） ：这道题广度优先遍历也很好写，可以通过这个问题理解一下为什么回溯算法都是深度优先遍历，并且都用递归来写。
 *
 * 四、游戏问题
 * 51. N 皇后（困难）：其实就是全排列问题，注意设计清楚状态变量，在遍历的时候需要记住一些信息，空间换时间；
 * 37. 解数独（困难）：思路同「N 皇后问题」；
 * 488. 祖玛游戏（困难）
 * 529. 扫雷游戏（困难）
 */
@HuiSu
public class Solution46 {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
