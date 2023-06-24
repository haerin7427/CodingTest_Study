-- https://school.programmers.co.kr/learn/courses/30/lessons/131117
-- title : 5월 식품들의 총매출 조회하기

SELECT P.PRODUCT_ID, P.PRODUCT_NAME, SUM(P.PRICE * O.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT AS P INNER JOIN FOOD_ORDER AS O ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE O.PRODUCE_DATE BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY PRODUCT_ID
ORDER BY TOTAL_SALES DESC, P.PRODUCT_ID;