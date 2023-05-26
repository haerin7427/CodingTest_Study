-- https://school.programmers.co.kr/learn/courses/30/lessons/59047
-- title : 이름에 el이 들어가는 동물 찾기
-- Created by haerin on 2023-05-26
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Dog' and NAME LIKE "%EL%"
ORDER BY NAME;