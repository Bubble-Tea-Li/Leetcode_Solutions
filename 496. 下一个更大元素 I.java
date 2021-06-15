class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*
        Time: O(N), Space: O(N)
        本题是个单调栈的经典题型；首先可以利用单调栈方法求出nums2中每个元素的下一个更大元素
        由于题目保证了元素都是不同的，因此可以把结果保存到hashmap之后，然后对于nums1进行扫描。
        */
        HashMap<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) nextGreater.put(nums2[i], stack.peek());
            stack.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}
