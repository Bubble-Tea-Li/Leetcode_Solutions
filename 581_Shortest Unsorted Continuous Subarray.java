class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int head = 0, end = nums.length - 1;
        while(head < nums.length){
            if(copy[head] != nums[head]){
                break;
            }
            head++;
        }
        while(end >= 0){
            if(copy[end] != nums[end]){
                break;
            }
            end--;
        }
        if(head < end)
            return end - head + 1;
        else
            return 0;
    }
}