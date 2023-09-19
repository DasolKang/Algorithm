-- 코드를 입력하세요
SELECT member_id MEMBER_ID, member_name MEMBER_NAME, gender GENDER, DATE_FORMAT(date_of_birth, '%Y-%m-%d') DATE_FORMAT
FROM member_profile
WHERE tlno is not null 
AND MONTH(date_of_birth)=3
AND gender='W'
ORDER BY member_id;

-- DATE_FORMAT(DATE_OF_BIRTH,'%Y-%m-%d')