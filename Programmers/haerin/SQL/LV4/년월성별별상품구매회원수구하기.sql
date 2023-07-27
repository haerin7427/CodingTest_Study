-- https://school.programmers.co.kr/learn/courses/30/lessons/131532
-- title : 년, 월, 성별 별 상품 구매 회원 수 구하기
-- created by haerin on 2023-07-27
SELECT DATE_FORMAT(ONLINE_SALE.sales_date, '%Y') AS YEAR
     , DATE_FORMAT(ONLINE_SALE.sales_date, '%m') AS MONTH
     , GENDER
     , COUNT(DISTINCT ONLINE_SALE.USER_ID) AS users
FROM ONLINE_SALE LEFT JOIN USER_INFO ON ONLINE_SALE.USER_ID = USER_INFO.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER;