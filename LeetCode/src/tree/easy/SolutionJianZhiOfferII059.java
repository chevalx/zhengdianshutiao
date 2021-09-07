package tree.easy;

import java.util.PriorityQueue;

public class SolutionJianZhiOfferII059 {

    class KthLargest {
        private PriorityQueue<Integer> elems = new PriorityQueue<>();
        private int k;
        public KthLargest(int k, int[] nums) {
            for (int num : nums) {
                elems.offer(num);
            }
            this.k = k;
        }

        public int add(int val) {
            elems.offer(val);
            while (elems.size() > k) {
                elems.poll();
            }
            return elems.peek();
        }
    }
}
