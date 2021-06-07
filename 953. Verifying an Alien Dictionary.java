class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // build a "map" of order
        int[] orders = new int[26];
        int num = 0;
        for (char ch : order.toCharArray()) {
            orders[ch - 'a'] = num;
            num++;
        }
        
        // check in sequence
        for (int i = 0; i < words.length - 1; i++) {
            if (notPrevious(words[i], words[i + 1], orders)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean notPrevious(String s1, String s2, int[] orders) {
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (orders[s1.charAt(i) - 'a'] != orders[s2.charAt(i) - 'a']) return orders[s1.charAt(i) - 'a'] > orders[s2.charAt(i) - 'a'];
        }
        return s1.length() > s2.length();
    }
}