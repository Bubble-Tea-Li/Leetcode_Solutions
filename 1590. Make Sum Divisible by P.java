class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length, res = n, need = 0, curr = 0;
        for (int num : nums) {
            need = (need + num) % p;
        }
        HashMap<Integer, Integer> lasts = new HashMap<>();
        lasts.put(0, -1);
        for (int i = 0; i < n; i++) {
            curr = (curr + nums[i]) % p;
            lasts.put(curr, i);
            int want = (curr - need + p) % p;
            res = Math.min(res, i - lasts.getOrDefault(want, -n));
        }
        
        return res < n ? res : -1;
    }
}