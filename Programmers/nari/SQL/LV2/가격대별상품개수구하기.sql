-- https://school.programmers.co.kr/learn/courses/30/lessons/59406
-- title : 가격대 별 상품 개수 구하기

-- SELECT TRUNCATE(X, D)
-- D번째 소수자리까지 포함 후, 짜른 X를 반환
-- D가 0 이면, 소수점없는 정수를 반환
-- D가 음수면, 정수기준 X 가 오른쪽부터 0 으로 채움
SELECT TRUNCATE(PRICE, -4) AS PRICE_GROUP, COUNT(PRODUCT_ID) AS PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP;