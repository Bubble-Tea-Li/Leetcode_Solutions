class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        /*
        Time: O(nlogn) Space: O(n)
        "田忌赛马"：把nums1排序，nums2用大顶堆
        斗得过就斗，斗不过就用最小的数去应付
        */
        PriorityQueue<int[]> maxq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < nums2.length; i++) {
            maxq.add(new int[] {i, nums2[i]});
        }
        Arrays.sort(nums1);

        int[] res = new int[nums1.length];
        int left = 0, right = nums1.length - 1;
        while (!maxq.isEmpty()) {
            int[] pair = maxq.poll();
            int index = pair[0], val = pair[1];
            if (val < nums1[right]) {
                res[index] = nums1[right];
                right--;
            } else {
                res[index] = nums1[left];
                left++;
            }
        }
        return res;
    }
}