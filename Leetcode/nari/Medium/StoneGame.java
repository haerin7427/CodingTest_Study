// https://leetcode.com/problems/stone-game/
// title : 877. Stone Game
// time taken : 

public class StoneGame {
    class Solution {
        public boolean stoneGame(int[] piles) {
            int alice = 0, bob = 0;
            int i = 0, j = piles.length-1;

            while(i < j) {
                if(piles[i] > piles[j]) {
                    alice += piles[i++];
                    bob += piles[j--];
                }
                else {
                    alice += piles[j--];
                    bob += piles[i++];
                }
            }

            return alice > bob;
        }
    }
}
