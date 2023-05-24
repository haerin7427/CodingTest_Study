-- https://school.programmers.co.kr/learn/courses/30/lessons/59040
-- title : 고양이와 개는 몇 마리 있을까

SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) AS count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
HAVING ANIMAL_TYPE IN ("Cat", "Dog")
ORDER BY ANIMAL_TYPE;