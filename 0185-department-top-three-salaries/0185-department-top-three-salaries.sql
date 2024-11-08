# Write your MySQL query statement below
SELECT 
Department.name AS Department, 
Employee_Rank.name AS Employee, 
Employee_Rank.salary AS Salary
FROM (
    SELECT 
    name, 
    salary, 
    departmentId,
    DENSE_RANK() OVER 
    (PARTITION BY departmentId ORDER BY salary DESC) AS RN
    FROM Employee
) AS Employee_Rank
JOIN Department ON Employee_Rank.departmentId = Department.id
WHERE Employee_Rank.RN <= 3; # no third-highest salary 조건 (3순위까지)