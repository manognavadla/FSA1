/*
Write a SQL procedure to retrieve all employees with their department names.

+-------+--------+-----------+------------+
| empno | ename  | job       | dname      |
+-------+--------+-----------+------------+
*/
DELIMITER //
CREATE PROCEDURE deptnames()
BEGIN 
Select e.empno,e.ename,e.job,d.dname  from emp e join dept d on e.deptno=d.deptno;
END//
DELIMITER ;


/*
write a sql procedure to count employees in each dept -dname empcount
*/
DELIMITER //
CREATE PROCEDURE deptcount()
BEGIN 
Select d.dname, count(e.empno) as empcount  from emp e join dept d on e.deptno=d.deptno group by e.deptno;
END//
DELIMITER ;
/*
write a sql procedure to list the deparments with no employees
*/
DELIMITER //
CREATE PROCEDURE noemp()
BEGIN 
select dname from dept where deptno not in (select distinct(deptno) from emp);
END//
DELIMITER ;
/*
Write a sql procedure to find employees with duplicate names
ename name_count
*/
DELIMITER //
CREATE PROCEDURE namesss()
BEGIN 
select ename, count(empno) as name_count from emp e group by ename having count(ename)>1;

END//
DELIMITER ;



/*
 5. Write a SQL procedure to find employees earning above 2500 and return their count.
**Procedure:** (IN parameter: min_salary = 2500)
CALL GetHighEarners(@count); SELECT @count;
+-------+---------+--------+
| ename | sal     | deptno |
+-------+---------+--------+

+--------+
| @count |
+--------+*/
DELIMITER //
CREATE PROCEDURE minsal(IN min_sal Decimal(10,2),OUT count INT )
BEGIN 
select ename, sal, deptno from emp where sal>min_sal;
select count(empno) into count from emp where sal>min_sal;
END//
DELIMITER ;
/* 6. Write a SQL procedure to list employees and their managers' names and count employees with no manager.
**Procedure:** (No IN parameters, only OUT)
+----------+-----------+---------+
| employee | job       | manager |
+----------+-----------+---------+

+---------+
| @no_mgr |
+---------+
*/
DELIMITER //
CREATE PROCEDURE managee(OUT count INT )
BEGIN 
select e.ename as emp, e.job, e1.ename from emp e join emp e1 on e.mgr=e1.empno;
select count(empno) into count from emp where mgr is null;
END//
DELIMITER ;
call managee(@count);
select @count;

/*
 7. Write a SQL procedure to calculate the total salary expenditure by department and return the highest total.
**Procedure:** (No IN parameters, only OUT)
CALL TotalSalaryByDept(@max); SELECT @max;
+------------+--------------+
| dname      | total_salary |
+------------+--------------+

+----------+
| @max     |
+----------+
*/
DELIMITER //
CREATE PROCEDURE totalsalary(OUT salaryy Decimal(10,2))
BEGIN 
select d.dname, sum(e.sal) from dept d join emp e on d.deptno=e.deptno group by e.deptno ;
select max(sum(e.sal)) into salaryy  from dept d join emp e on d.deptno=e.deptno group by e.deptno order by sum(e.sal) desc limit 1 ;
END//
DELIMITER ;
call totalsalary(@count);
select @count



;
/*
 8. Write a SQL procedure to find employees hired before '1995-01-01' and return their average salary.
**Procedure:** (IN parameter: cutoff_date = '1995-01-01')
**Execution Command:** CALL GetEmpByHireDate(@avg); SELECT @avg;

-- Result of SELECT in procedure:
+-------+-------+------------+
| empno | ename | hiredate   |
+-------+-------+------------+
*/
DELIMITER //
CREATE PROCEDURE avg(IN da date,OUT salaryy Decimal(10,2))
BEGIN 
select empno,ename,hiredate from emp where hiredate<da;
select avg(sal) into salaryy from emp where hiredate<da;
END//
DELIMITER ;
call avg('1995-01-01',@count);
select @count;
/*
 9. Write a SQL procedure to assign salary grades to employees and return the highest grade assigned.
**Procedure:** (No IN parameters, only OUT)

**Execution Command:** CALL AssignSalaryGrades(@max); SELECT @max;

-- Result of SELECT in procedure:
+--------+---------+-------+
| ename  | sal     | grade |
+--------+---------+-------+
     
-- Result of SELECT @max:
+------+
| @max |
+------+
*/
drop procedure if exists AssignSalaryGrades;
delimiter //
create procedure AssignSalaryGrades(OUT max int)
BEGIN
select e.ename, e.sal, g.grade from emp e join salgrade g on e.sal between g.losal and g.hisal;
select max(g.grade) into max from emp e join salgrade g on e.sal between g.losal and g.hisal;
end//
delimiter ;


/* 
10. Write a SQL procedure to find the highest-paid employee in each department and return the overall highest salary.
**Procedure:** (No IN parameters, only OUT)

**Execution Command:** CALL GetTopEarnerByDept(@top); SELECT @top;

-- Result of SELECT in procedure:
+------------+-------+------------+
| dname      | ename | max_salary |
+------------+-------+------------+

-- Result of SELECT @top:
+---------+
| @top    |
+---------+
*/
drop procedure if exists GetTopEarnerByDept;
delimiter //
create procedure GetTopEarnerByDept(OUT top decimal(10,2))
BEGIN
select d.dname,e.ename, e.sal as max_salary from emp e join dept d on e.deptno=d.deptno
where e.sal=(select max(e2.sal) from emp e2 where e2.deptno=e.deptno);
select max(sal) into top from emp;
END//
delimiter ;

/*
 11. Write a SQL procedure to update employee commission to 1000 for 'SALESMAN' and track the number of updates.
**Procedure:** (IN parameters: job_type = 'SALESMAN', new_comm = 1000)

**Execution Command:** CALL UpdateCommByJob(@count); SELECT @count;

-- Result of SELECT in procedure:
+-------+--------+----------+---------+
| empno | ename  | job      | comm    |
+-------+--------+----------+---------+

-- Result of SELECT @count:
+--------+
| @count |
+--------+
*/
drop procedure if exists UpdateCommByJob;
delimiter //
create procedure UpdateCommByJob(out count int)
begin 

update emp set comm=1000 where job='salesman';
select count(e.empno) into count from emp e where e.job='salesman';
end//
delimiter ;

/*
 12. Write a SQL procedure to calculate average salary by job title and modify 'CLERK' average.
**Procedure:** (IN parameter: target_job = 'CLERK')

**Execution Command:** SET @avg = 0; CALL AvgSalaryByJob(@avg); SELECT @avg;

-- Result of SELECT in procedure:
+-----------+-------------+
| job       | avg_salary  |
+-----------+-------------+

-- Result of SELECT @avg:
+---------+
| @avg    |
+---------+
*/
drop procedure if exists AvgSalaryByJob;
delimiter //
create procedure AvgSalaryByJob(OUT avg decimal(10,2))
begin
select e.job, avg(e.sal) from emp e group by e.job;
update emp set sal=sal*1.01 where job='CLERK';
SELECT AVG(sal) INTO avg FROM emp WHERE job = 'CLerk';
end//
delimiter ;
/*
 13. Write a SQL procedure to increase salaries by 10% for department 20 and track the total increase.
**Procedure:** (IN parameters: dept_num = 20, pct = 10)

**Execution Command:** CALL IncreaseSalByDept(@increase); SELECT @increase;

-- Result of SELECT in procedure:
+-------+-------+---------+
| empno | ename | sal     |
+-------+-------+---------+

-- Result of SELECT @increase:
+-----------+
| @increase |
+-----------+
*/
drop procedure if exists IncreaseSalByDept;
delimiter //
create procedure IncreaseSalByDept(OUT increase Decimal(10,2))
begin
declare prev decimal(10,2);
declare new decimal(10,2);
select sum(sal) into prev from emp where emp.deptno=20;
select empno ,ename,sal from emp where deptno=20;
update emp set sal =sal+(0.1*sal) where deptno=20;
select empno ,ename,sal from emp where deptno=20;
select sum(sal) into new from emp where emp.deptno=20;
set increase=new-prev;
end//
delimiter ;
/*
 14. Write a SQL procedure to find employees with no commission in grade 4 and count them.
**Procedure:** (IN parameter: grade_num = 4)
 **Execution Command:** CALL GetNoCommByGrade(@count); SELECT @count;

-- Result of SELECT in procedure:
+-------+---------+-------+
| ename | sal     | grade |
+-------+---------+-------+

-- Result of SELECT @count:
+--------+
| @count |
+--------+
*/
drop procedure if EXISTS GetNoCommByGrade;
delimiter //
create procedure GetNoCommByGrade(OUT count int)
begin
select e.ename,e.sal,s.grade from emp e join salgrade s on e.sal between s.losal and s.hisal;
select count(e.ename) into count from emp e join salgrade s on e.sal between s.losal and s.hisal group by s.grade having s.grade=4;
end//
delimiter ;

/*
 15. Write a SQL procedure to list employees reporting to manager 7698 and modify their count.
**Procedure:** (IN parameter: mgr_id = 7698)

**Execution Command:** SET @count = 0; CALL GetSubordinates(@count); SELECT @count;

-- Result of SELECT in procedure:
+-------+--------+----------+
| empno | ename  | job      |
+-------+--------+----------+

-- Result of SELECT @count:
+--------+
| @count |
+--------+
*/
DROP PROCEDURE IF EXISTS GetSubordinates;
DELIMITER //
CREATE PROCEDURE GetSubordinates(IN mgr_id INT, INOUT emp_count INT)
BEGIN
    SELECT COUNT(*) INTO emp_count FROM emp WHERE mgr = mgr_id;
    SELECT empno, ename, job FROM emp WHERE mgr = mgr_id;
END //
DELIMITER ;


/*
 16. Write a SQL procedure to find departments with above-average employee count and return the average.
**Procedure:** (No IN parameters, only OUT)

**Execution Command:** CALL AboveAvgEmpDepts(@avg); SELECT @avg;

-- Result of SELECT in procedure:
+------------+-----------+
| dname      | emp_count |
+------------+-----------+

-- Result of SELECT @avg:
+------+
| @avg |
+------+
*/
DROP PROCEDURE IF EXISTS AboveAvgEmpDepts;
DELIMITER //
CREATE PROCEDURE AboveAvgEmpDepts(OUT avg_emp_count DECIMAL(10,2))
BEGIN
    -- Calculate the average number of employees per department
    SELECT AVG(dept_counts.emp_count) INTO avg_emp_count
    FROM (
        SELECT d.deptno, COUNT(e.empno) AS emp_count
        FROM dept d
        LEFT JOIN emp e ON d.deptno = e.deptno
        GROUP BY d.deptno
    ) AS dept_counts;
    
    -- Select departments with above-average employee count
    SELECT d.dname, COUNT(e.empno) AS emp_count
    FROM dept d
    JOIN emp e ON d.deptno = e.deptno
    GROUP BY d.dname
    HAVING COUNT(e.empno) > avg_emp_count
    ORDER BY emp_count DESC;
END //
DELIMITER ;

/*
 17. Write a SQL procedure to calculate total commission by department and return the maximum commission.
**Procedure:** (No IN parameters, only OUT)

**Execution Command:** CALL TotalCommByDept(@max); SELECT @max;

-- Result of SELECT in procedure:
+------------+------------+
| dname      | total_comm |
+------------+------------+
-- Result of SELECT @max:

+---------+
| @max    |
+---------+
*/
drop procedure if exists TotalCommByDept;
delimiter //
create procedure TotalCommByDept(OUT max decimal(10,2))
begin
select d.dname, sum(e.comm) as total_comm from emp e join dept d on e.deptno=d.deptno group by e.deptno;
select max(e.comm) into max from emp e;
end//
delimiter ;
CALL TotalCommByDept(@max); SELECT @max;

/*
 18. Write a SQL procedure to find employees hired in the same year as employee 7499 and count them.
**Procedure:** (IN parameter: emp_id = 7499)

**Execution Command:** CALL SameHireYear(@count); SELECT @count;

-- Result of SELECT in procedure:
+-------+--------+------------+
| empno | ename  | hiredate   |
+-------+--------+------------+

-- Result of SELECT @count:
+--------+
| @count |
+--------+
*/
drop procedure if exists SameHireYear;
delimiter //
create procedure SameHireYear(IN ei INT, OUT count INT)
begin 
declare hire date;
select hiredate into hire from emp where empno=ei;
select count(empno) into count from emp where emp.hiredate=hire;
end//
delimiter ;
/*
 19. Write a SQL procedure to rank employees by salary within their department and return the highest rank count.
**Procedure:** (No IN parameters, only OUT)

**Execution Command:** CALL RankEmpBySalary(@max); SELECT @max;

-- Result of SELECT in procedure:
+--------+---------+------------+-------------+
| ename  | sal     | dname      | salary_rank |
+--------+---------+------------+-------------+

-- Result of SELECT @max:
+------+
| @max |
+------+
*/


/*
 20. Write a SQL procedure to transfer employees from dept 30 to dept 40, increase salaries by 500, and track count.
**Procedure:** (IN parameters: old_dept = 30, new_dept = 40, sal_increase = 500)

**Execution Command:** CALL TransferAndUpdateSalary(@count); SELECT @count;

-- Result of SELECT in procedure:
+-------+--------+---------+--------+
| empno | ename  | sal     | deptno |
+-------+--------+---------+--------+

-- Result of SELECT @count:
+--------+
| @count |
+--------+




*/
