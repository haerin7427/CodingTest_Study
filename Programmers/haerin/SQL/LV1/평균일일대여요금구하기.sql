-- https://school.programmers.co.kr/learn/courses/30/lessons/151136
-- title : 평균 일일 대여 요금 구하기
-- Created by haerin on 2023-05-12
SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV';