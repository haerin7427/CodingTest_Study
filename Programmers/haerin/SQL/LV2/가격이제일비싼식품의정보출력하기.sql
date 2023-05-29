-- https://school.programmers.co.kr/learn/courses/30/lessons/131115
-- title : 가격이 제일 비싼 식품의 정보 출력하기
-- Created by haerin on 2023-05-23
SELECT *
FROM FOOD_PRODUCT
WHERE PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT);

SELECT *
FROM FOOD_PRODUCT
ORDER BY PRICE DESC
LIMIT 1;