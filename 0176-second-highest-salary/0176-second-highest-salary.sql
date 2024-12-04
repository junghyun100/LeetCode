# Write your MySQL query statement below
SELECT 
MAX(salary) AS SecondHighestSalary
FROM Employee
WHERE salary < (SELECT MAX(salary) FROM Employee); -- 단순 서브쿼리로 풀리는데 미들?