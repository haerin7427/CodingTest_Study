-- https://school.programmers.co.kr/learn/courses/30/lessons/133025
-- title : 과일로 만든 아이스크림 고르기

SELECT F.FLAVOR AS FLAVOR
FROM FIRST_HALF AS F INNER JOIN ICECREAM_INFO AS I ON F.FLAVOR = I.FLAVOR
WHERE F.TOTAL_ORDER > 3000 AND I.INGREDIENT_TYPE = "fruit_based"
ORDER BY F.TOTAL_ORDER DESC;