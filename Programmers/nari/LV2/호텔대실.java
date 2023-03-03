// https://school.programmers.co.kr/learn/courses/30/lessons/155651
// title : 호텔 대실

import java.util.*;

public class 호텔대실 {
    class Solution1 {
        public int solution(String[][] book_time) {
            // 시작 시간, 종료 시간 분단위로 변환
            int[][] book = new int[book_time.length][2];
            
            for(int i=0;i<book_time.length;i++) {
                book[i][0] = change(book_time[i][0]);
                // 청소 시간 10분
                book[i][1] = change(book_time[i][1]) + 10;
            }
            
            // 시작 시간 기준으로 정렬
            Arrays.sort(book, (a, b) -> {
                // 시작 시간이 같을 경우, 종료 시간 기준으로 정렬
                if(a[0] == b[0]) 
                    return a[1] - b[1];
                else return a[0] - b[0];
            });
            
            // 가장 빨리 비는 방
            PriorityQueue<Integer> room = new PriorityQueue<>();
            
            for(int[] time : book) {
                // 첫 번째 예약이 아니고, 담겨있는 종료 시간보다 다음 시작 시간이 큰 경우
                if(!room.isEmpty() && time[0] >= room.peek()) {
                    room.poll();
                    room.add(time[1]);
                }
                else room.add(time[1]);
            }
            
            return room.size();
        }
        
        // 시간을 분단위로 변환
        int change(String time) {
            String[] t = time.split(":");
            
            return Integer.valueOf(t[0])*60 + Integer.valueOf(t[1]);
        }
    }

    // 객체 사용 - 1보다 느림
    class Solution2 {
        class Book{
            int start_time, end_time;
            
            public Book(int start_time, int end_time) {
                this.start_time = start_time;
                this.end_time = end_time;
            }
        }
        
        public int solution(String[][] book_time) {
            ArrayList<Book> bookList=new ArrayList<>();
            
            for(String[] book : book_time) {
                int start_time = toMinute(book[0]);
                int end_time = toMinute(book[1]);

                bookList.add(new Book(start_time,end_time));
            }
            
            // 시작 시간대로 정렬
            Collections.sort(bookList, (o1,o2) -> {
                if(o1.start_time == o2.start_time) 
                    return o1.end_time - o2.end_time;
                else return o1.start_time - o2.start_time;
            });
            
            // 방 리스트 (end time이 들어있음)
            ArrayList<Integer> roomList = new ArrayList<>();
            
            for(Book book : bookList) {
                // 객실 이어서 사용한 경우 = true, 새로운 객실 필요 = false
                boolean isOk = false;
                
                for(int i=0;i<roomList.size();i++) {
                    // 청소 시간 10분
                    int endTime = roomList.get(i) + 10;
                    
                    // 현재 대실 시작 시간이 list에 담겨있는 종료 시간보다 크거나 같을 경우
                    if(book.start_time >= endTime) {
                        // 종료 시간 업데이트
                        roomList.set(i, book.end_time);
                        isOk = true;
                        break;
                    }
                }
                
                // 아무 방도 넣지 못한 경우, 새로운 방 추가
                if(!isOk) roomList.add(book.end_time);
            }
            
            return roomList.size();
        }
        
        // 시간을 분단위로 변환
        int toMinute(String time) {
            StringTokenizer stk = new StringTokenizer(time, ":");
            
            int hour = Integer.parseInt(stk.nextToken());
            int minute = Integer.parseInt(stk.nextToken());
            
            return hour*60 + minute;
        }
    }
}