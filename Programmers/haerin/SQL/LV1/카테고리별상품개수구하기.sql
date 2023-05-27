-- https://school.programmers.co.kr/learn/courses/30/lessons/131529
-- title : 카테고리 별 상품 개수 구하기
-- created by haerin on 2023-05-27
SELECT LEFT(PRODUCT_CODE,2) AS CATEGORY, COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY LEFT(PRODUCT_CODE,2)
ORDER BY PRODUCT_CODE;