class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        Time: O(Nlog(k)) Space: O(N)
        利用一个大顶堆，保存最大值的index，窗口移动之后，删除k位前的元素

        关键点：出队方法需要优化，不是直接remove，这样需要logn的额外时间
        而是直接比较最上方的值与当前的i的大小，这样是O(1)的
        */
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((o1, o2) -> nums[o2] - nums[o1]);
        for (int i = 0; i < k - 1; i++) {
            heap.add(i);
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            if (i + k - 1 < nums.length) heap.add(i + k - 1);
            res[i] = nums[heap.peek()];
            
            while (!heap.isEmpty() && heap.peek() <= i) {
                heap.poll();
            }
        }

        return res;
    }
}
