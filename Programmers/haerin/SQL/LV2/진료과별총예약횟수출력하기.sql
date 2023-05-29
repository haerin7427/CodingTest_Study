-- https://school.programmers.co.kr/learn/courses/30/lessons/132202
-- title : 진료과별 총 예약 횟수 출력하기
-- created by haerin on 2023-0
SELECT MCDP_CD AS 진료과코드, COUNT(*) AS 5월예약건수
FROM APPOINTMENT
WHERE APNT_YMD >= '2022-05-01' and APNT_YMD <= '2022-05-31'
-- WHERE DATE_FORMAT(APNT_YMD, '%y-%m') like '22-05'
GROUP BY MCDP_CD
ORDER BY 5월예약건수, 진료과코드;