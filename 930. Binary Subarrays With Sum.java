class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        int sum = 0;
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - goal)) {
                result += preSum.get(sum - goal);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
            
        return result;
    }
}