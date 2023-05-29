-- https://school.programmers.co.kr/learn/courses/30/lessons/59412
-- title : 입약 시각 구하기(1)
-- Created by haerin on 2023-05-26
SELECT DATE_FORMAT(DATETIME, "%H") AS HOUR, count(*) AS COUNT
FROM ANIMAL_OUTS
WHERE DATE_FORMAT(DATETIME, '%H') BETWEEN 9 AND 20
GROUP BY DATE_FORMAT(DATETIME, "%H")
ORDER BY HOUR ASC;