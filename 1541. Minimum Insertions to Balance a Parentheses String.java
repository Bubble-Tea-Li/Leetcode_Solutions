class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int right = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (right % 2 != 0) {
                    res++;
                    right--;
                }
                right += 2;
            } else {
                right--;
                if (right < 0) {
                    res++;
                    right += 2;
                }
            }
        }
        
        return res + right;
    }
}