-- https://school.programmers.co.kr/learn/courses/30/lessons/131116
-- title : 식품분류별 가장 비싼 식품의 정보 조회하기

SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN (
        SELECT CATEGORY, MAX(PRICE)
        FROM FOOD_PRODUCT
        GROUP BY CATEGORY
        HAVING CATEGORY IN ('과자', '국', '김치', '식용유')
    )
ORDER BY MAX_PRICE DESC;