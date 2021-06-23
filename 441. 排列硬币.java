class Solution {
    public int arrangeCoins(int n) {
        /*
        Time: O(logn) Space: O(1)
        可以试试看二分搜索
        对于一个mid，可以计算n与1 + 2 + .. + n的关系
        注意点：可能溢出，应用long
        */
        if (n == 0 || n == 1) return n;
        int left = 1, right = n;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long curr = mid * (mid + 1) / 2;
            if (curr == n) return (int) mid;
            else if (curr < n) left = (int) mid + 1;
            else right = (int) mid;
        }

        return left - 1;
    }
}
