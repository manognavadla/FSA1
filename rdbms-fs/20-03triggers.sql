/*
### Setup (Already in your schema)

### 1. BEFORE INSERT Trigger
Write a SQL Trigger to ensure salary is not below the department minimum salary before inserting a new employee into the emp table.


Trigger 1
INSERT INTO emp VALUES (9991, 'TEST1', 'CLERK', 7902, '23/1/1', 600, 0, 20);


+-------+--------+-----------+------+------------+---------+---------+--------+
| empno | ename  | job       | mgr  | hiredate   | sal     | comm    | deptno |
+-------+--------+-----------+------+------------+---------+---------+--------+*/
drop trigger if exists belowminsal;
delimiter //
create trigger belowminsal
before insert 
on emp for each row
begin
declare minsal decimal(10,2);
declare dept int;set dept=new.deptno;
select min(sal) into minsal from emp where deptno=dept group by deptno ;
if(new.sal<minsal) THEN
SIGNAL SQLSTATE '02000' set MESSAGE_TEXT='no salary below min sal';
end if;
end //
delimiter ;

/*
### 2. AFTER INSERT Trigger
Write a SQL Trigger to log new employee hires with their department details in the emp_audit table after insertion into the emp table.


Trigger 2
INSERT INTO emp VALUES (9992, 'TEST2', 'ANALYST', 7566, '23/1/2', 2000, NULL, 20);

SELECT * FROM emp_audit;

+----+-------+-------+--------+---------------------+----------+
| id | empno | ename | deptno | changedat           | action   |
+----+-------+-------+--------+---------------------+----------+
|  1 |  9992 | TEST2 |     20 | 2025-03-20 02:03:11 | New Hire |
+----+-------+-------+--------+---------------------+----------+
---
*/
drop trigger if exists afterempinsert;
delimiter //
CREATE TRIGGER afterempinsert 
    after insert ON emp
    FOR EACH ROW 
BEGIN
    INSERT INTO emp_audit
    SET action = 'New Hire',
      empno = new.empno,
      ename = new.ename,
	  deptno = new.deptno,
      changedat = NOW(); 
END //
delimiter ;

/*
### 3. BEFORE UPDATE Trigger
Write a SQL Trigger to prevent department changes if the employee is a manager before updating the emp table.


-- Trigger 3 
UPDATE emp SET deptno = 30 WHERE empno = 7782;
(45000): Cannot change department of a manager

UPDATE emp SET sal = 3500 WHERE empno = 7788;

+-------+--------+-----------+------+------------+---------+---------+--------+
| empno | ename  | job       | mgr  | hiredate   | sal     | comm    | deptno |
+-------+--------+-----------+------+------------+---------+---------+--------+
---
*/
drop trigger if exists beforeupdate;
delimiter //
create trigger beforeupdate
before update on emp 
for each row
begin
declare j varchar(50);
select job into j from emp where empno=new.empno;
if(j='MANAGER' && new.deptno!= old.deptno) then 
SIGNAL SQLSTATE '02000' set MESSAGE_TEXT='Cannot change department of a manager';
end if;
end //
delimiter ;

/*
### 4. AFTER UPDATE Trigger
Write a SQL Trigger to record salary changes in the emp_audit table after an update to the emp table.


-- Trigger 4

UPDATE emp SET sal = 4500 WHERE empno = 7788;

SELECT * FROM emp_audit;
+----+-------+-------+--------+---------------------+----------------------------------------+
| id | empno | ename | deptno | changedat           | action                                 |
+----+-------+-------+--------+---------------------+----------------------------------------+
|  1 |  7788 | SCOTT |     20 | 2025-03-20 02:07:39 | Salary changed from 3500.00 to 4500.00 |
+----+-------+-------+--------+---------------------+----------------------------------------+

---
*/
drop trigger if exists afterupdate;
delimiter //
create trigger afterupdate
after update on emp 
for each row
begin
INSERT INTO emp_audit
    SET action = concat('salary changed from ',old.sal,'to ', new.sal ),
      empno = OLD.empno,
      ename = OLD.ename,
	  deptno = OLD.deptno,
      changedat = NOW(); 
end //
delimiter ;

/*
### 5. BEFORE DELETE Trigger
Write a SQL Trigger to prevent deletion of employees with commission before deleting from the emp table.


-- Trigger 5 
DELETE FROM emp WHERE empno = 7499; 
(45000): Cannot delete employee with commission

DELETE FROM emp WHERE empno = 7900;

SELECT * FROM emp;

+-------+--------+-----------+------+------------+---------+---------+--------+
| empno | ename  | job       | mgr  | hiredate   | sal     | comm    | deptno |
+-------+--------+-----------+------+------------+---------+---------+--------+
---
*/
drop trigger if exists beforedelete;
delimiter //
create trigger beforedelete
before delete on emp 
for each row
begin
if(old.comm is not null) then 
signal SQLSTATE '45000' set MESSAGE_TEXT='Cannot delete employee with commission';
end if;
end //
delimiter ;

/*
### 6. AFTER DELETE Trigger
Write a SQL Trigger to log deleted employees with their job title in the emp_audit table after deletion from the emp table.


-- Trigger 6
DELETE FROM emp WHERE empno = 7839; 
+----+-------+-------+--------+---------------------+----------------------------------------+
| id | empno | ename | deptno | changedat           | action                                 |
+----+-------+-------+--------+---------------------+----------------------------------------+
|  1 |  7839 | KEVIN |     40 | 2025-03-20 02:14:22 | Deleted - Job: PRESIDENT               |
+----+-------+-------+--------+---------------------+----------------------------------------+
DELETE FROM emp WHERE empno = 7876;
+----+-------+-------+--------+---------------------+----------------------------------------+
| id | empno | ename | deptno | changedat           | action                                 |
+----+-------+-------+--------+---------------------+----------------------------------------+
|  1 |  7839 | KEVIN |     40 | 2025-03-20 02:14:22 | Deleted - Job: PRESIDENT               |
|  2 |  7876 | KEVIN |     20 | 2025-03-20 02:15:41 | Deleted - Job: CLERK                   |
+----+-------+-------+--------+---------------------+----------------------------------------+
SELECT * FROM emp_audit;
*/
drop trigger if exists afterdeletejob;
delimiter //
create trigger afterdeletejob
after delete on emp 
for each row
begin
INSERT INTO emp_audit
    SET action = concat('Deleted- job ',old.job),
      empno = OLD.empno,
      ename = OLD.ename,
	  deptno = OLD.deptno,
      changedat = NOW(); 
end //
delimiter ;