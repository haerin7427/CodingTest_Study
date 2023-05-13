-- https://school.programmers.co.kr/learn/courses/30/lessons/133025
-- title : 과일로 만든 아이스크림 고르기
-- Created by haerin on 2023-05-13
SELECT ICECREAM_INFO.FLAVOR
FROM ICECREAM_INFO
LEFT JOIN FIRST_HALF ON ICECREAM_INFO.FLAVOR = FIRST_HALF.FLAVOR
WHERE TOTAL_ORDER > 3000 and INGREDIENT_TYPE = 'fruit_based'
ORDER BY TOTAL_ORDER DESC;