class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build a graph by hashmap and calculate all points' indegrees
        // follow by the indegree, just go from indegree == 0, and reduce
        // the children one by one, when indegree == 0, put them into the queue
        
        // build graph and indegree
        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            indegree.put(parent, indegree.get(parent) + 1);
            graph.get(child).add(parent);
        }
        
        Queue<Integer> coursesQueue = new LinkedList<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                coursesQueue.add(key);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!coursesQueue.isEmpty()) {
            int course = coursesQueue.poll();
            result.add(course);
            if (graph.get(course).size() > 0) {
                for (int child : graph.get(course)) {
                    indegree.put(child, indegree.get(child) - 1);
                    if (indegree.get(child) == 0) {
                        coursesQueue.add(child);
                    }
                }
            }
        }
        
        if (result.size() < numCourses) return new int[0];
        
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = result.get(i);
        }
        
        return res;
    }
}