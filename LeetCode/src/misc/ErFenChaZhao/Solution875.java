package misc.ErFenChaZhao;

// 二分查找的应用题
// 抽象成一个单调函数，一个自变量x，一个因变量y，y中包含target
public class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        // H是target
        // 自变量是K，单调函数为：
        // 以每小时吃掉K个香蕉的速度，用多长时间吃掉所有香蕉
        int left = 1;
        int right = 1000000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) == h) {
                right = mid;
                //                left = mid + 1;
            } else if (f(piles, mid) < h) {
                right = mid;
            } else if (f(piles, mid) > h) {
                left = mid + 1;
            }
        }
        return left;
    }

    public int f(int[] piles, int speed) {
        int total = 0;
        for (int i = 0; i < piles.length; i++) {
            total += (piles[i] / speed);
            if (piles[i] % speed > 0) {
                total++;
            }
        }
        return total;
    }


    public static void main(String[] args) {
//        System.out.println(3 % 8);
        System.out.println(new Solution875().minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
}
