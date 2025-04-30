/*1)
Write a SQL query to calculate the total revenue per customer, excluding cancelled orders, 
for those with at least two orders between October 10 and October 15, 2024.

Expected Output Columns:
------------------------ 
+----------------+--------------+
| Name           | TotalRevenue |
+----------------+--------------+

Note: 
-----
Database name: customer_orders

Tables in customer_orders:  Customers                                                                       
                            OrderItems                                                                      
                            Orders                                                                          
                            Products
*/
SELECT c.Name, SUM(o.TotalCost) AS TotalRevenue FROM Customers c JOIN Orders o ON c.CustomerID = o.CustomerID WHERE o.Status != 'Cancelled' AND o.OrderDate BETWEEN '2024-10-10' AND '2024-10-15'
AND c.CustomerID IN (SELECT CustomerID FROM Orders WHERE Status != 'Cancelled' AND OrderDate BETWEEN '2024-10-10' AND '2024-10-15' GROUP BY CustomerID HAVING COUNT(*) >= 2) GROUP BY c.Name;
/*
Write a SQL query to find the customer with the highest average order cost, 
excluding cancelled orders.

Expected Output Columns:
------------------------
+--------------+-------------+
| Name         | AvgCost     |
+--------------+-------------+

Note: 
-----
Database name: customer_orders

Tables in customer_orders:  Customers                                                                       
                            OrderItems                                                                      
                            Orders                                                                          
                            Products
*/
SELECT c.Name, AVG(o.TotalCost) AS AVGCost FROM Customers c JOIN Orders o ON c.CustomerID = o.CustomerID WHERE o.Status != 'Cancelled' GROUP BY c.Name order by AVGCost desc limit 1;

/*
Write a SQL query to find the customer who ordered the most keyboards, 
using pattern matching and aggregate functions.

Expected Output Columns:
------------------------
+---------------+---------------+
| Name          | KeyboardCount |
+---------------+---------------+

Note: 
-----
Database name: customer_orders

Tables in customer_orders:  Customers                                                                       
                            OrderItems                                                                      
                            Orders                                                                          
                            Products
*/
SELECT c.Name, SUM(oi.Quantity) AS KeyboardCount FROM Customers c JOIN Orders o ON c.CustomerID = o.CustomerID JOIN OrderItems oi ON o.OrderID = oi.OrderID JOIN Products p ON oi.ProductID = p.ProductID WHERE p.Name LIKE '%Keyboard%' GROUP BY c.Name ORDER BY KeyboardCount DESC LIMIT 1;

/*
Write a SQL query to list products ordered in both 'Shipped' and 'Processing' statuses 
but not 'Cancelled'.

Expected Output Columns:
------------------------
+------------+
| Name       |
+------------+

Note: 
-----
Database name: customer_orders

Tables in customer_orders:  Customers                                                                       
                            OrderItems                                                                      
                            Orders                                                                          
                            Products

*/
select p.Name from Product P join OrderItems oi ON p.ProductID=oi.ProductID join Orders on oi.OrderID=o.OrderID WHERE o.status in ('Shipped','Processing') and p.ProductID NOT IN (SELECT p2.ProductID FROM Products p2 JOIN OrderItems oi2 ON p2.ProductID=oi2.ProductID join Orders o2 ON oi2.OrderID=o2.OrderID where o2.status='Cancelled') GROUP BY p.ProductID, p.Name HAVING COUNT(DISTINCT o.Status)=2;
/* Write a SQL query to find the top 3 most expensive products never ordered.

Expected Output Columns:
------------------------
+------------+--------+
| Name       | Price  |
+------------+--------+

Note: 
-----
Database name: customer_orders

Tables in customer_orders:  Customers                                                                       
                            OrderItems                                                                      
                            Orders                                                                          
                            Products

*/
select p.Name, p.Price from Products p where p.ProductID not in (select productID from OrderItems) order by p.price desc limit 3;
/* Write a SQL Query Using a Correlated Subquery to Get the Latest Order for Each Customer

Expected Output Columns:
------------------------
+---------+------------+------------+-----------+
| OrderID | CustomerID | OrderDate  | TotalCost |
+---------+------------+------------+-----------+

Note: 
-----
Database name: customer_orders

Tables in customer_orders:  Customers                                                                       
                            OrderItems                                                                      
                            Orders                                                                          
                            Products

*/
select o.OrderID,o.CustomerID, o.OrderDate,o.TotalCost from Orders o where o.OrderDate=(select MAX(OrderDate) from Orders where o.CustomerID=CustomerID);
/* Write a SQL Query to Find the Most Frequently Ordered Product.

Expected Output Columns:
------------------------
+-------+---------------+
| Name  | TotalQuantity |
+-------+---------------+

Note: 
-----
Database name: customer_orders

Tables in customer_orders:  Customers                                                                       
                            OrderItems                                                                      
                            Orders                                                                          
                            Products

*/
select p.Name, SUM(o.Quantity) as TotalQuantity from Products p join OrderItems o on p.ProductID=o.ProductID group by o.ProductID order by TotalQuantity desc limit 1 ;
/* Write a SQL Query to Find orders that were placed on weekends.

Expected Output Columns:
------------------------
+---------+------------+------------+
| OrderID | CustomerID | OrderDate  |
+---------+------------+------------+

Note: 
-----
Database name: customer_orders

Tables in customer_orders:  Customers                                                                       
                            OrderItems                                                                      
                            Orders                                                                          
                            Products

*/
select OrderID, CustomerID, OrderDate from Orders where DAYOFWEEK(OrderDate) in (1,7);