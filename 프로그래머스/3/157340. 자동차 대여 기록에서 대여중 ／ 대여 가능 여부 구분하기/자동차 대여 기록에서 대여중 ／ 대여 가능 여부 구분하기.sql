-- 코드를 입력하세요
SELECT car_id, 
    IF(SUM(IF('2022-10-16' between start_date and end_date, 1, 0))=0, '대여 가능', '대여중')
    as AVAILABILITY
FROM car_rental_company_rental_history
GROUP BY car_id
ORDER BY car_id desc;