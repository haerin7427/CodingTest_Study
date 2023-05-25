-- https://school.programmers.co.kr/learn/courses/30/lessons/59041
-- title : 동명 동물 수 찾기
-- Created by haerin on 2023-05-24
SELECT NAME, COUNT(NAME) AS COUNT
FROM ANIMAL_INS
GROUP BY NAME
HAVING COUNT(NAME) >= 2 AND NAME IS NOT NULL
ORDER BY NAME;