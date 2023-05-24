-- https://school.programmers.co.kr/learn/courses/30/lessons/59041
-- title : 동명 동물 수 찾기

SELECT NAME, COUNT(NAME) AS COUNT
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
HAVING COUNT(NAME) > 1
ORDER BY NAME;