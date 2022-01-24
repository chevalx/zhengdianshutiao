package array.easy;

/**
 * 差分数组用于对某个数据区间的整体加减，例如对num[i...j]中的元素都加3
 * 则我们构造一个新数组diff[n]，然后对diff[i]+3，diff[j+1]-3
 * 然后对diff求前缀和数组即可得到变化后的num
 *
 *
 * 370. 区间加法（中等）
 * 1109. 航班预订统计（中等）
 * 1094. 拼车（中等）
 */
public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            //每个记录
            int first_i = bookings[i][0];
            int last_i = bookings[i][1];
            int seats_i = bookings[i][2];
            for (int j = first_i; j <= last_i; j++) {
                res[j-1] += seats_i;
            }
        }
        return res;
    }

    public int[] corpFlightBookingsBetter(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            //每个记录
            int first_i = bookings[i][0];
            int last_i = bookings[i][1];
            int seats_i = bookings[i][2];
            res[first_i-1]+=seats_i;
            if (last_i < n) {
                res[last_i] -= seats_i;
            }
        }

        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
