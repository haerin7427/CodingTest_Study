-- https://school.programmers.co.kr/learn/courses/30/lessons/59040
-- title : 고양이와 개는 몇 마리 있을까
-- Created by haerin on 2023-05-24
SELECT ANIMAL_TYPE, COUNT(*) AS count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
HAVING ANIMAL_TYPE = 'Cat' or ANIMAL_TYPE = 'Dog'
ORDER BY ANIMAL_TYPE;