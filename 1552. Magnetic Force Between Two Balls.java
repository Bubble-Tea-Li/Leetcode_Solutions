class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 0, right = position[position.length - 1] - position[0];
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (count(position, mid) >= m) {
                left = mid;
            } else {
                right = mid - 1; 
            }
        }
        
        return left;
    }
    
    private int count(int[] position, int d) {
        int ans = 1, curr = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - curr >= d) {
                ans++;
                curr = position[i];
            }
        }
        return ans;
    }
}