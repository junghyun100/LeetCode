CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
        SELECT
            salary
        FROM
            (
                SELECT
                    salary,
                    DENSE_RANK() OVER (ORDER BY salary DESC) AS salaryRank
                FROM
                    Employee
            ) AS rankedSalaries
        WHERE salaryRank = N
        LIMIT 1
  );
END