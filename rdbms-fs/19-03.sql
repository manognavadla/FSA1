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


