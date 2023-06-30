-- https://school.programmers.co.kr/learn/courses/30/lessons/59044
-- title : 오랜 기간 보호한 동물(1)
-- created by haerin on 2023-06-30
SELECT I.NAME, I.DATETIME
FROM ANIMAL_INS I LEFT JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE O.ANIMAL_ID IS NULL
ORDER BY I.DATETIME
LIMIT 3;