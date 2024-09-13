SELECT DISTINCT id, email, first_name, last_name
FROM developers d
JOIN skillcodes s
ON s.code & d.skill_code = s.code
WHERE s.name IN ('Python', 'C#')
ORDER BY id;