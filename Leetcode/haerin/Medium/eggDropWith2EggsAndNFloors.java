package Leetcode.haerin.Medium;
// https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/description/
// title : 1884. Egg Drop With 2 Eggs and N Floors
// type : ...
// time : ...
// created by haerin on 2023-06-07
public class eggDropWith2EggsAndNFloors {
    class Solution {
        public int twoEggDrop(int n) {
            // 1 2 2 3 3 3 4 4 4 4 5 5 5 5 5
            int x = 1;
            while(n > 0) {
                n -= x++;
            }
            return x-1;
        }
    }
}
