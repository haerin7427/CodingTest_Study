-- https://school.programmers.co.kr/learn/courses/30/lessons/144854
-- title : 조건에 맞는 도서와 저자 리스트 출력하기
-- created by haerin on 2023-05-27
SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK LEFT JOIN AUTHOR ON BOOK.AUTHOR_ID = AUTHOR.AUTHOR_ID
WHERE CATEGORY = '경제'
ORDER BY PUBLISHED_DATE;