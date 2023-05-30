-- https://school.programmers.co.kr/learn/courses/30/lessons/131530
-- title : 가격대 별 상품 개수 구하기
-- created by haerin on 2023-05-30
SELECT (PRICE - PRICE % 10000) AS PRICE_GROUP, COUNT(*) AS PRODUCTS
FROM PRODUCT 
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP;