class Solution {
    public boolean checkValidString(String s) {
        // cmin is the least ( should be paired, cmax is max ( could be paired
        int cmin = 0, cmax = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cmin++;
                cmax++;
            } else if (ch == ')') {
                cmin--;
                cmax--;
            } else {
                cmin--;
                cmax++;
            }
            if (cmax < 0) return false;
            cmin = Math.max(cmin, 0);
        }
        return cmin == 0;
    }
}