class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] counter = new int[k];
        TreeSet<Integer> available = new TreeSet<Integer>();
        for(int num = 0; num < k; num++){
            available.add(num);
        }
        
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for(int index = 0; index < arrival.length; index++){
            int currTime = arrival[index];
            int endTime = currTime + load[index];
            while(!busyServers.isEmpty() && busyServers.peek()[0] <= currTime){
                int freedServer = busyServers.poll()[1];
                available.add(freedServer);
            }
            if(available.size() == 0) continue;
            Integer assignNum = available.ceiling(index % k);
            if(assignNum == null)
                assignNum = available.first();
            counter[assignNum]++;
            available.remove(assignNum);
            busyServers.offer(new int[]{endTime, assignNum});
        }
        
        return findMax(counter);
    }
    
    private List<Integer> findMax(int[] counter){
        int max = 0;
        for(int count : counter){
            max = Math.max(max, count);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < counter.length; i++){
            if(counter[i] == max)
                result.add(i);
        }
        return result;
    }
}