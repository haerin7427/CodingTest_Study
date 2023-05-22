-- https://school.programmers.co.kr/learn/courses/30/lessons/59406
-- title : 가격이 제일 비싼 식품의 정보 출력하기

SELECT *
FROM FOOD_PRODUCT
ORDER BY PRICE DESC
LIMIT 1;