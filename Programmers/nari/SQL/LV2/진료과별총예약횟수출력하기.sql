-- https://school.programmers.co.kr/learn/courses/30/lessons/132202
-- title : 진료과별 총 예약 횟수 출력하기

SELECT MCDP_CD AS 진료과코드, COUNT(APNT_NO) AS 5월예약건수
FROM APPOINTMENT
WHERE YEAR(APNT_YMD) = 2022 AND MONTH(APNT_YMD) = 5
GROUP BY 진료과코드
ORDER BY 5월예약건수, 진료과코드;