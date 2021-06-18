class Solution {
    public int climbStairs(int n) {
        /*
        可推导得递推公式：f(x) = f(x - 1) + f(x - 2)
        然后并不需要之前的内容，因此实际上一直用两个变量就足够了
        */
        if (n <= 2) return n;
        int first = 0, second = 1;
        int curr = first + second;
        for (int i = 2; i <= n; i++) {
            curr = first + second;
            first = second;
            second = curr;
        }

        return first + second;
    }
}
