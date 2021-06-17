class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        /*
        Time: O(nlogn) Space: O(n)
        本题的话，由于只保证了行和列的有序性，虽然还是应该考虑堆
        但是，初始化的时候，应该优先把每一行的首位加入，随后依次向后取元素
        */
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((o1, o2) -> matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]]);
        for (int i = 0; i < matrix.length; i++) {
            heap.add(new int[] {i, 0});
        }
        int[] index = new int[2];
        while (k > 0) {
            index = heap.poll();
            k--;
            if (index[1] + 1 < matrix[0].length) {
                heap.add(new int[] {index[0], index[1] + 1});
            }
        }

        return matrix[index[0]][index[1]];
    }
}
