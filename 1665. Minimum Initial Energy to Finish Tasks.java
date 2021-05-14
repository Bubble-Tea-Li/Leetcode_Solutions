class Solution {
    public int minimumEffort(int[][] tasks) {
        int res = 0;
        Arrays.sort(tasks, (t1, t2) -> (t1[1] - t1[0]) - (t2[1] - t2[0]));
        for (int[] task : tasks) {
            res = Math.max(res + task[0], task[1]);
        }
        return res;
    }
}