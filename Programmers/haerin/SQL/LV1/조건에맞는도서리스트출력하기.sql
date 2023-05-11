-- https://school.programmers.co.kr/learn/courses/30/lessons/144853
-- title : 조건에 맞는 도서 리스트 출력하기
-- Created by haerin on 2023-05-10
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE,'%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK
WHERE CATEGORY = '인문' and PUBLISHED_DATE >= '2021-01-01' and PUBLISHED_DATE <= '2021-12-31'
ORDER BY PUBLISHED_DATE;