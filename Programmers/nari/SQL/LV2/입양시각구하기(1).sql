-- https://school.programmers.co.kr/learn/courses/30/lessons/59412
-- title : 입양 시각 구하기(1)

SELECT HOUR(DATETIME) AS HOUR, COUNT(ANIMAL_ID) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING 9 <= HOUR AND HOUR < 20
ORDER BY HOUR;