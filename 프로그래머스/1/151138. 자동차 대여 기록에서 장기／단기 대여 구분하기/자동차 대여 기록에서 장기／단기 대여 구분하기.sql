-- 코드를 입력하세요
SELECT history_id, car_id, DATE_FORMAT(start_date, '%Y-%m-%d') as START_DATE, DATE_FORMAT(end_date, '%Y-%m-%d') as END_DATE,
    IF (DATEDIFF(end_date, start_date)+1 >= 30, '장기 대여', '단기 대여') as RENT_TYPE
FROM car_rental_company_rental_history
WHERE start_date LIKE '2022-09%'
ORDER BY history_id DESC;