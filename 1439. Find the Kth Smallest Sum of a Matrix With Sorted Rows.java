class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // use a heap to save every row
        // when meeting a new line, just add first k / length of column to a new heap
        // Time: O(m*n*k*log(k))
        int col = Math.min(mat[0].length, k);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] row : mat) {
            PriorityQueue<Integer> nextPq = new PriorityQueue<>(Collections.reverseOrder());;
            for (int i : pq) {
                for (int c = 0; c < col; c++) {
                    nextPq.add(i + row[c]);
                    if (nextPq.size() > k) nextPq.poll();
                }
            }
            pq = nextPq;
        }
        return pq.poll();
    }
}