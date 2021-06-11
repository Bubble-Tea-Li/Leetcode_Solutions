class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        /*
        这题非常类似于merge k sorted list
        就是先把每个list的头节点加进小顶堆，同时维护一个最大值max
        每次出堆时，比较当前max-val与之前保存的end-start的情况，如果变短，保存当前值
        然后把出堆的元素向前寻找一个元素入堆，注意此时也应该更新一下当前最大值，直到出来的元素达到某个列表的结尾
        */

        int n = nums.size();
        int inf = 0x3f3f3f;
        int max = -inf;
        int start = -inf;
        int end = inf;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));

        for (int i = 0; i < n; i++) {
            int val = nums.get(i).get(0);
            pq.add(new Node(i, 0, val));
            max = Math.max(max, val);
        }

        while (pq.size() == n) {
            Node node = pq.poll();
            int i = node.i;
            int j = node.j;
            int val = node.val;

            if (max - val < end - start) {
                start = val;
                end = max;
            }

            if (j + 1 < nums.get(i).size()) {
                int nVal = nums.get(i).get(j + 1);
                pq.offer(new Node(i, j + 1, nVal));
                max = Math.max(max, nVal);
            }
        }

        return new int[] {start, end};
    }
}

class Node {
    int i, j, val;

    public Node(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}