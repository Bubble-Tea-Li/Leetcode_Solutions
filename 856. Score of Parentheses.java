class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(curr);
                curr = 0;
            } else if (ch == ')') {
                curr = stack.pop() + Math.max(curr * 2, 1);    
            }
        }
        
        return curr;
    }
}