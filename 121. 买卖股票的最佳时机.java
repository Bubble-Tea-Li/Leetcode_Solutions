class Solution {
    public int maxProfit(int[] prices) {
        /*
        Time: O(n) Space: O(1)
        用一个指针记录最小值，随后向前遍历
        */
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) ans = Math.max(ans, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return ans;
    }
}
