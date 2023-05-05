-- https://school.programmers.co.kr/learn/courses/30/lessons/132201
-- title : 12세 이하인 여자 환자 목록 출력하기
-- Created by haerin on 2023-05-05
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO,'NONE')
FROM PATIENT
WHERE GEND_CD = 'W' AND AGE <= 12
ORDER BY AGE DESC, PT_NAME;