-- https://school.programmers.co.kr/learn/courses/30/lessons/132204
-- title : 취소되지 않은 진료 예약 조회하기

SELECT P.APNT_NO, P.PT_NAME, P.PT_NO, P.MCDP_CD, D.DR_NAME, P.APNT_YMD
FROM (
    SELECT P.PT_NO, P.PT_NAME, A.APNT_NO, A.APNT_YMD, A.MCDP_CD, A.MDDR_ID
    FROM PATIENT AS P INNER JOIN APPOINTMENT AS A ON P.PT_NO = A.PT_NO
    WHERE DATE_FORMAT(A.APNT_YMD, '%Y-%m-%d') = '2022-04-13' AND A.APNT_CNCL_YN = 'N' AND A.MCDP_CD = 'CS'
) AS P INNER JOIN DOCTOR AS D ON P.MDDR_ID = D.DR_ID
ORDER BY P.APNT_YMD;