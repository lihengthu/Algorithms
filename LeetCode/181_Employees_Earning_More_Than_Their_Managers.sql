// 1.
select e1.Name as Employee
from Employee e1, Employee m1
where e1.ManagerId = m1.Id and e1.Salary > m1.Salary;

// 2.
SELECT
    a.Name AS Employee
FROM Employee  a JOIN Employee AS b
    ON a.ManagerId = b.Id AND a.Salary > b.Salary;
