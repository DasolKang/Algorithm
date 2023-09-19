-- 코드를 입력하세요
SELECT count(*) USERS
FROM user_info
WHERE age>=20 AND age<=29
AND year(JOINED)=2021;