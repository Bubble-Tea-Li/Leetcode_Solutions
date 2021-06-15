class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        Time: O(N), Space: O(N)
        依旧可以是用单调栈,不过需要用的是从开头开始扫描的模板
        */
        int[] days = new int[temperatures.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                days[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return days;
    }
}
