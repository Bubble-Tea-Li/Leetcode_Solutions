class Solution {
    public int findTheLongestSubstring(String s) {
        int res = 0, curr = 0, n = s.length();
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0; i < n; i++) {
            curr ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1;
            seen.putIfAbsent(curr, i);
            res = Math.max(res, i - seen.get(curr));
        }
        return res;
    }
}