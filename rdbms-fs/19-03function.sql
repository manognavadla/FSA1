
SET GLOBAL log_bin_trust_function_creators = 1;

/*
1. Write a SQL function to calculate years of service for an employee as of March 18, 2025.

**Query:** SELECT empno, ename, hiredate, YearsOfService(empno) AS years_of_service FROM emp ORDER BY years_of_service DESC LIMIT 5;

+-------+-------+------------+------------------+
| empno | ename | hiredate   | years_of_service |
+-------+-------+------------+------------------+
*/
drop function if exists YearsOfService;
delimiter //
create function YearsOfService(empno INT) returns INT
begin
declare years int;
select TIMESTAMPDIFF(YEAR, hiredate, '2025-03-08') into years from emp e where e.empno=empno;
return years;
end//
delimiter ;


/*
2. Write a SQL function to calculate an employee’s total compensation (salary + commission).

**Query:** SELECT empno, ename, sal, comm, TotalCompensation(empno) AS total_comp FROM emp WHERE comm IS NOT NULL ORDER BY total_comp DESC;

+-------+--------+---------+---------+------------+
| empno | ename  | sal     | comm    | total_comp |
+-------+--------+---------+---------+------------+*/
drop function if exists TotalCompensation;
delimiter //
create function TotalCompensation(empno INT) returns decimal(10,2)
begin
declare commission decimal(10,2);
declare sal decimal(10,2);
declare comm decimal(10,2);
select e.sal, e.comm into sal,comm from emp e where e.empno=empno;
set commission=sal+comm;
return commission;
end//
delimiter ;
/*
 3. Write a SQL function to return the department name for an employee.

**Query:** SELECT empno, ename, deptno, GetDeptName(empno) AS dept_name FROM emp ORDER BY empno LIMIT 5;

+-------+--------+--------+------------+
| empno | ename  | deptno | dept_name  |
+-------+--------+--------+------------+
*/
delete function if exists GetDeptName;
delimiter //
create function GetDeptName(empno int) returns varchar(50)
begin
declare dept_name varchar(50);
select d.dname into dept_name from emp e join dept d on e.deptno=d.deptno where e.empno=empno;
return dept_name;
end//
delimiter ;
/*
 4. Write a SQL function to check if an employee’s salary exceeds a threshold of 3000.

**Query:** SELECT empno, ename, sal, ExceedsThreshold(empno) AS above_3000 FROM emp ORDER BY sal DESC LIMIT 5;

+-------+-------+---------+------------+
| empno | ename | sal     | above_3000 |
+-------+-------+---------+------------+
*/
delete funuction if exists ExceedsThreshold;
delimiter //
create function ExceedsThreshold(empno int) returns tinyint(1)
begin
declare bool tinyint(1);
select case
when e.sal>3000 then 1 else 0
end into bool from emp e where e.empno=empno;
return bool;
end//
delimiter ;
/*
 5. Write a SQL function to calculate the tax (10% of salary) for an employee.

**Query:** SELECT empno, ename, sal, CalculateTax(empno) AS tax FROM emp WHERE deptno = 20 ORDER BY sal DESC;

+-------+-------+---------+--------+
| empno | ename | sal     | tax    |
+-------+-------+---------+--------+
*/
delete function if exists CalculateTax;
delimiter //
create function CalculateTax(empno int) returns decimal(10,2)
begin
declare sal decimal(10,2);
select 0.1*e.sal into sal from emp e where e.empno=empno;
return sal;
end//
delimiter ;
/*
 6. Write a SQL function to return the manager’s name for an employee.

**Query:** SELECT empno, ename, mgr, GetManagerName(empno) AS manager_name FROM emp WHERE mgr IS NOT NULL ORDER BY empno LIMIT 5;
+-------+--------+------+--------------+
| empno | ename  | mgr  | manager_name |
+-------+--------+------+--------------+
*/
delete function if exists GetManagerName;
delimiter //
create function GetManagerName(empno int) returns varchar(50)
begin
declare mna varchar(50);
select e2.ename into mna from emp e1 join emp e2 on e1.mgr=e2.empno where e1.empno=empno;
return mna;
end //
delimiter ;
/*
 7. Write a SQL function to calculate the annual salary for an employee.

**Query:** SELECT empno, ename, sal, AnnualSalary(empno) AS annual_salary FROM emp WHERE job = 'SALESMAN';

+-------+--------+---------+---------------+
| empno | ename  | sal     | annual_salary |
+-------+--------+---------+---------------+
*/
delete function if exists AnnualSalary;
delimiter //
create function AnnualSalary(empno int) returns decimal(10,2)
begin 
declare ann decimal(10,2);
select 12*e.sal into ann from emp e where e.empno=empno;
return ann;
end//
delimiter ;

/*
 8. Write a SQL function to determine if an employee has a commission.

**Query:** SELECT empno, ename, comm, HasCommission(empno) AS has_comm FROM emp ORDER BY empno LIMIT 5;

+-------+--------+---------+----------+
| empno | ename  | comm    | has_comm |
+-------+--------+---------+----------+*/

delete function if exists HasCommission;
DELIMITER //

CREATE FUNCTION HasCommission(emp_id INT) 
RETURNS TINYINT(1) DETERMINISTIC
BEGIN
    DECLARE bool TINYINT(1);

    SELECT IF(comm IS NOT NULL, 1, 0) INTO bool 
    FROM emp 
    WHERE empno = emp_id;

    RETURN bool;
END //

DELIMITER ;

/*

 9. Write a SQL function to calculate the percentage of salary relative to a threshold of 5000.

**Query:** SELECT empno, ename, sal, SalaryPercentage(empno) AS sal_percent FROM emp ORDER BY sal DESC LIMIT 5;

+-------+-------+---------+-------------+
| empno | ename | sal     | sal_percent |
+-------+-------+---------+-------------+*/

delete function if exists SalaryPercentage;
delimiter //
create function SalaryPercentage(empno int) returns decimal(10,2)
begin
declare per decimal(10,2);
select (e.sal/5000)*100 into per from emp e where  e.empno=empno;
return per;
end //
delimiter ;

/*

 10. Write a SQL function to return the hire year of an employee.

**Query:** SELECT empno, ename, hiredate, HireYear(empno) AS hire_year FROM emp WHERE deptno = 30;

+-------+-------+------------+-----------+
| empno | ename | hiredate   | hire_year |
+-------+-------+------------+-----------+

*/
delete function if exists HireYear;
delimiter //
create function HireYear(empno int) returns int
begin
declare hyear int;
select year(e.hiredate) into hyear from emp e where e.empno=empno;
return hyear;
end//
delimiter ;