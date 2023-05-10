-- https://school.programmers.co.kr/learn/courses/30/lessons/131535
-- title : 조건에 맞는 회원수 구하기
-- Created by haerin on 2023-05-09
SELECT COUNT(*)
FROM USER_INFO
WHERE JOINED >= '2021-01-01' and JOINED < '2022-01-01' and AGE >= 20 and AGE < 30;