class Solution {
    public int maxWidthRamp(int[] nums) {
        /*
        Time: O(N) Space: O(N)
        先使用一个单调栈，保存递减的元素
        然后从结尾重新扫描回去
        */
        int n = nums.length;
        int maxWidth = 0;

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                int pos = stack.pop();
                maxWidth = Math.max(maxWidth, i - pos);
            }
        }

        return maxWidth;
    }
}
