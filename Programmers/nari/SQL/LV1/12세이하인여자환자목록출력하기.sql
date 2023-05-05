-- https://school.programmers.co.kr/learn/courses/30/lessons/132201
-- title : 12세 이하인 여자 환자 목록 출력하기

SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, "NONE") AS TLNO
FROM PATIENT
WHERE AGE < 13 AND GEND_CD  = "W"
ORDER BY AGE DESC, PT_NAME;
-- ORDER BY AGE DESC, PT_NAME ASC;