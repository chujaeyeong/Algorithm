-- MEMBER_ID 기준으로 두 테이블 JOIN
-- 서브쿼리로 리뷰를 가장 많이 작성한 회원을 추출 (LIMIT 1)
-- 리뷰 작성일 기준 오름차순, 텍스트 기준 오름차순 

SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE,'%Y-%m-%d') AS REVIEW_DATE
FROM REST_REVIEW R
JOIN MEMBER_PROFILE M ON M.MEMBER_ID = R.MEMBER_ID
WHERE M.MEMBER_ID = 
                    (SELECT MEMBER_ID
                    FROM REST_REVIEW
                    GROUP BY MEMBER_ID
                    ORDER BY COUNT(*) DESC
                    LIMIT 1)
ORDER BY REVIEW_DATE, REVIEW_TEXT;