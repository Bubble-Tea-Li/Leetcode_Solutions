class Solution {
    public int[] nextGreaterElements(int[] nums) {
        /*
        Time: O(N), Space: O(N)
        比起496题，多了一个循环数组的要求
        解决办法是把数组的最后再“延伸”一遍前n-1个元素即可
        */
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        int n = nums.length;
        Stack<Integer> stack = new Stack();
        for (int i = n * 2 - 2; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) ans[i % n] = stack.peek();
            stack.push(nums[i % n]);
        }
        return ans;
    }
}
