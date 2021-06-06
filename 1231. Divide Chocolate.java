class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int num : sweetness) {
            sum += num;
            min = Math.min(num, min);
        }
        if (K + 1 == 1) return sum;
        int left = min, right = (int) 1e9 / (K + 1);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int curr = 0, cuts = 0;
            for (int sweet : sweetness) {
                curr += sweet;
                if (curr >= mid) {
                    curr = 0;
                    cuts++;
                    if (cuts > K) break;
                }
            }
            if (cuts > K) left = mid + 1;
            else right = mid;
        }
        return left - 1;
    }
}