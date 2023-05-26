// https://leetcode.com/problems/all-paths-from-source-to-target/
// title : 797. All Paths From Source to Target
// time taken : 

public class AllPathsFromSourcetoTarget {
    class Solution {
        List<List<Integer>> list = new ArrayList();
        int len = 0;

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            len = graph.length;
            List<Integer> arrList = new ArrayList();
            arrList.add(0);

            dfs(graph, 0, arrList);

            return list;
        }

        public void dfs(int graph[][], int idx, List<Integer> arrList){
            if(idx == len-1) {
                list.add(new ArrayList(arrList));
                return;
            }

            for(int n : graph[idx]) {
                arrList.add(n);
                dfs(graph, n, arrList);
                arrList.remove(arrList.size()-1);
            }
        }
    }
}
