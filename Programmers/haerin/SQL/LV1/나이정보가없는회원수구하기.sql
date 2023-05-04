-- https://school.programmers.co.kr/learn/courses/30/lessons/131528
-- title : 나이 정보가 없는 회원 수 구하기
-- Created by haerin on 2023-05-03
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE AGE IS NULL;