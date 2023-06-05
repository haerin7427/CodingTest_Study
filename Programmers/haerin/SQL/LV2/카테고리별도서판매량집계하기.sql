-- https://school.programmers.co.kr/learn/courses/30/lessons/144855
-- title : 카테고리 별 도서 판매량 집계하기
-- created by haerin on 2023-06-04
SELECT CATEGORY, SUM(SALES) AS TOTAL_SALES
FROM BOOK LEFT JOIN BOOK_SALES ON BOOK.BOOK_ID = BOOK_SALES.BOOK_ID
WHERE DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY CATEGORY
ORDER BY CATEGORY;