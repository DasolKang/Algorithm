-- 코드를 입력하세요
SELECT ROUND(SUM(daily_fee)/COUNT(daily_fee), 0) AVERAGE_FEE
FROM car_rental_company_car
WHERE car_type = 'SUV';
