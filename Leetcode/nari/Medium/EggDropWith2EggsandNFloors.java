// https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
// title : 1884. Egg Drop With 2 Eggs and N Floors
// time taken : 

public class EggDropWith2EggsandNFloors {
    class Solution {
        public int twoEggDrop(int n) {
            int cnt = 0, x = 1;

            while(n > 0) {
                cnt++;
                n -= x++;
            }

            return cnt;
        }
    }
}
