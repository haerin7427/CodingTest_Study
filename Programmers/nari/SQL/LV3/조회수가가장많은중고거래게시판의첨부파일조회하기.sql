-- https://school.programmers.co.kr/learn/courses/30/lessons/164671
-- title : 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기

SELECT CONCAT('/home/grep/src/', F.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, F.FILE_EXT) AS FILE_PATH
FROM (
    SELECT BOARD_ID
    FROM USED_GOODS_BOARD
    ORDER BY VIEWS DESC
    LIMIT 1
    ) AS B INNER JOIN USED_GOODS_FILE AS F ON B.BOARD_ID = F.BOARD_ID
ORDER BY F.FILE_ID DESC;