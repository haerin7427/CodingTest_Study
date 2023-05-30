// https://leetcode.com/problems/binary-watch/
// title : 401. Binary Watch
// time taken : 

public class BinaryWatch {
    // backtracking 사용
    class Solution1 {
        List<String> list = new ArrayList<>();
        int[] time = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

        public List<String> readBinaryWatch(int turnedOn) {
            backtrack(0, 0, 0, turnedOn);

            return list;
        }

        private void backtrack(int position, int hours, int min, int limit) {
            // led가 갯수만큼 다 켜져있을 경우
            if(limit == 0) {
                if(hours <= 11 && min <= 59) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(hours).append(":").append(min <= 9 ? "0" + min : min);
                    list.add(sb.toString());
                }

                return;
            }

            for(int i=position;i<10;i++) {
                if(i < 4) hours += time[i];
                else min += time[i];

                backtrack(i+1, hours, min, limit-1);

                if(i < 4) hours -= time[i];
                else min -= time[i];
            }
        }
    }

    // Integer.bitCount() 사용
    class Solution2 {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> list = new ArrayList<>();
            
            for(int hour=0;hour<12;hour++) {
                for(int min=0;min<60;min++) {
                    if(Integer.bitCount(hour) + Integer.bitCount(min) == turnedOn) {
                        list.add(String.format("%d:%02d", hour, min));
                        // if(min < 10) list.add(String.format("%d:0%d", hour, min));
                        // else list.add(String.format("%d:%d", hour, min));
                    }
                }
            }

            return list;
        }
    }
}
