package misc.ErFenChaZhao;

public class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        // days 是target
        int left = 0;
        int right = 1;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) == days) {
                right = mid - 1;
            } else if (f(weights, mid) < days) {
                right = mid - 1;
            } else if (f(weights, mid) > days) {
                left = mid + 1;
            }
        }
        if (left > 501 || f(weights, left) != days) {
            return -1;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution1011 s = new Solution1011();
        System.out.println(s.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    public int f(int[] weights, int shipWeight) {
        // 已知船的运载能力x，返回天数y
        int days = 1;
        int accumulatedWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            if (accumulatedWeight + weights[i] > shipWeight) {
                days++;
                accumulatedWeight = weights[i];
            } else {
                accumulatedWeight += weights[i];
            }
        }
        return days;
//        int days = 0;
//        for (int i = 0; i < weights.length;) {
//            int cap = shipWeight;
//            while (i < weights.length) {
//                if (cap < weights[i]) break;
//                else cap -= weights[i];
//                i++;
//            }
//            days++;
//        }
//        return days;
    }
}
