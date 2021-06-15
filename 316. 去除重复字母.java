class Solution {
    public String removeDuplicateLetters(String s) {
        /*
        smaller：先思考一个小问题，如果只去除一个字母，怎么做？
        其实就是找到第一个s[i] > s[i + 1]的地方，弹出它
        现在的问题被化作弹出所有，所以可以维护一个单调栈，保证都是上升的栈，遇到比后面大的就弹出
        但是还有额外条件：有且只有一次
        因此：用过一次的，就不能再用，一共只有一次出现的，不能弹出
        */
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        boolean[] used = new boolean[26];
        Deque<Character> stack = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // used用于标记是否已经在stack中
            if (!used[ch - 'a']) {
                // 维护单调栈
                while (!stack.isEmpty() && stack.peekLast() > ch) {
                    if (counts[stack.peekLast() - 'a'] > 0) {
                        used[stack.peekLast() - 'a'] = false;
                        stack.pollLast();
                    } else {
                        break;
                    }
                }
                used[ch - 'a'] = true;
                stack.addLast(ch);
            }
            // 遍历过一个点之后，都要把counts减少一
            counts[ch - 'a']--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        return sb.toString();
    }
}
