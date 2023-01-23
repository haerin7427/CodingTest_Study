// https://school.programmers.co.kr/learn/courses/30/lessons/67256
// title : 키패드 누르기

public class 키패드누르기 {
    class Solution1 {
        public String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();
            int left = 10, right = 12;
            
            for(int i=0;i<numbers.length;i++) {
                int n = numbers[i];
                
                if(n == 1 || n == 4 || n == 7) {
                    sb.append("L");
                    left = n;
                }
                else if(n == 3 || n == 6 || n == 9) {
                    sb.append("R");
                    right = n;
                }
                else {
                    // 위,아래로 움직일 때는 '/3'
                    // 좌,우 로 움직이는 거리는 '%3'
                    if(n == 0) n = 11;
                    
                    int leftDiff = (Math.abs(n - left) / 3) + (Math.abs(n - left) % 3);
                    int rightDiff =(Math.abs(n - right) / 3) + (Math.abs(n - right) % 3);
                    
                    if(leftDiff == rightDiff) {
                        if(hand.equals("right")) {
                            right = n;
                            sb.append("R");
                        }
                        else {
                            left = n;
                            sb.append("L");
                        }
                    } 
                    else if(leftDiff > rightDiff) {
                        right = n;
                        sb.append("R");
                    }
                    else {
                        left = n;
                        sb.append("L");
                    }
                }
            }
            
            return sb.toString();
        }
    }

    class Solution2 {
        // 키패드 좌표 {y,x}
        int[][] numpadPos = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}  //9
        };
        
        //초기 위치
        int[] leftPos = {3,0};
        int[] rightPos = {3,2};
        
        public String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();
            
            for(int num : numbers) {
                String position = pushNumber(num, hand);
                sb.append(position);

                if(position.equals("L")) {
                    leftPos = numpadPos[num]; 
                    continue;
                }
                else if(position.equals("R")) {
                    rightPos = numpadPos[num];
                    continue;
                }
            }
            
            return sb.toString();
        }
        
        String pushNumber(int num, String hand) {
            if(num==1 || num==4 || num==7) return "L";
            if(num==3 || num==6 || num==9) return "R";

            if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
            if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";

            //같으면 손잡이
            return hand.equals("right") ? "R" : "L";
        }
        
        int getDist(int[] pos, int num) {
            return Math.abs(pos[0]-numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
        }
    }
}