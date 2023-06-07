// https://leetcode.com/problems/sort-integers-by-the-power-value/
// title : 1387. Sort Integers by The Power Value
// time taken : 

import java.util.*;

public class SortIntegersbyThePowerValue {
    // 실패
    class Solution1 {
        public int getKth(int lo, int hi, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] val = new int[hi-lo+1];
            int idx = 0;

            for(int i=lo;i<=hi;i++) {
                int n = i;
                int cnt = 0;

                while(n != 1) {
                    if(n%2 == 0) n /= 2;
                    else n = 3 * n + 1;

                    cnt++;
                }

                map.put(i, cnt);
            }

            List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort(Map.Entry.comparingByValue());
            
            for(Map.Entry<Integer, Integer> entry : entryList) {
                val[idx++] = entry.getKey();
            }

            return val[k-1];
        }
    }

    class Solution2 {
        HashMap<Integer, Integer> map = new HashMap<>();

        public int getKth(int lo, int hi, int k) {
            int[][] val = new int[hi-lo+1][2];
            int idx = 0;

            for(int i=lo;i<=hi;i++) {
                val[idx][0] = i;
                val[idx++][1] = find(i);
            }

            Arrays.sort(val, (a,b) -> a[1]-b[1]);

            return val[k-1][0];
        }

        private int find(int num) {
            if(num == 1) return 0;
            if(map.containsKey(num)) return map.get(num);

            int cnt = 0;

            if(num%2 == 0) cnt = 1 + find(num/2);
            else cnt = 1 + find(3 * num + 1);

            map.put(num, cnt);

            return cnt;
        }
    }
}
