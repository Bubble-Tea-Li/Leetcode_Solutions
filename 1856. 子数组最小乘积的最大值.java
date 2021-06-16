class Solution {
    public int maxSumMinProduct(int[] nums) {
        /*
        双向都使用单调递减栈，保证在栈内的元素都是最小值
        然后计算每个i的左侧第一个更小的值的index，然后计算右侧第一个更小的值的index
        随后计算一下前缀和，对于每个点，用自身的大小* (presum[右侧第一个更小的index] - presum[左侧第一个更小的index + 1]) 恰好求得一个序列区间的和
        */
        int len = nums.length;

        int[] lefti = new int[len];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) lefti[i] = -1;
            else lefti[i] = stack.peek();
            stack.push(i);
        }

        int[] righti = new int[len];
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) righti[i] = len;
            else righti[i] = stack.peek();
            stack.push(i);
        }

        long[] preSum = new long[len + 1];
        for (int i = 1; i <= len; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }

        long res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, nums[i] * (preSum[righti[i]] - preSum[lefti[i] + 1]));
        }
        return (int)(res % (1000000007));
    }
}
