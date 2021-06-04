class Solution {
    public int findBestValue(int[] arr, int target) {
        int left, right, mid, sum = 0, max = -1;
        for (int v : arr) {
            sum += v;
            max = Math.max(max, v);
        }
        
        if (sum <= target) return max;
        
        for (left = 1, right = max; left < right; ) {
            mid = left + (right - left) / 2;
            sum = 0;
            for (int v : arr) sum += (v > mid) ? mid : v;
            if (sum >= target) right = mid;
            else left = mid + 1;
        }
        
        int s1 = 0, s2 = 0;
        for (int v : arr) {
            s1 += (v > left) ? left : v;
            s2 += (v > left - 1) ? (left - 1) : v;
        }
        
        return (Math.abs(s2 - target) <= Math.abs(s1 - target)) ? left - 1 : left;
    }
}