class Solution {
    public String removeKdigits(String num, int k) {
        /*
        Time: O(N) Space: O(N)
        首先构造一个单调栈，只保存递减的内容
        这题如果使用纯stack的话，最终保存结果时，leading zero问题比较难解决
        使用deque的话，最后可以按queue的方式入队，会比较容易。
        */
        if (k >= num.length() || num.length() == 0) return "0";
        Deque<Character> stack = new LinkedList();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }

        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char digit = stack.pollFirst();
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            res.append(digit);
        }
        
        return res.length() == 0 ? "0" : res.toString();
    }
}
