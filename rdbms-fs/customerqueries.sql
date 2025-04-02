/*
Retrieve the names and total costs of orders where the status is "Shipped" and the total cost is greater than 1500.

List all orders where the status is either "Delivered" or "Cancelled."

Get all the details of orders that do not belong to customer ID 20.

Get the customer names and their order status where the total cost is greater than 1000 or the order status is "Pending."

Get the list of customers who have not placed any orders.

Retrieve the customer names and their total order costs where the total cost is between 1000 and 3000 (inclusive).

Retrieve orders placed between the years 1995 and 1999.

Retrieve orders where the total cost is between 300 and 1000.

Retrieve orders that belong to customers with customer IDs between 20 and 40.

List all product price ranges where the price is between 20 and 40.

Get orders where the status is not "Cancelled" and the total cost is below 2000.

Retrieve orders that do not have an associated customer (i.e., missing customer details).

Get orders placed between 1996 and 2000 by customers with names starting with "C" or "S."

List orders where the customer ID is 7788 or 7566 and the total cost is less than 3000.

Retrieve customers whose names contain 'ar' anywhere.

Retrieve customers whose names are exactly 5 letters long and start with 'K.'

Retrieve customers whose names do not end with 'n.'

Retrieve customers whose names start with 'C' or 'S.'

Perform the sum of total order costs by customers in customer ID 30.

Get the maximum and minimum order total costs for customers in customer IDs 20 or 40.

Find customers who have placed more orders than the average number of orders placed by all customers.

Find the name and order count of the customer who has placed the highest number of orders.

Find customers who have placed more orders than the highest order count of any customer in region X.

Find customers whose total order value is higher than that of 'John Doe'.

Find customers who have placed orders for the same product as 'Jane Smith'.

Find regions that have at least one customer who has placed an order worth more than $3000.

Find customers who placed their first order before the first order placed in region Y.

Find the second highest order value among all customers.

Find customers who have the same representative as 'Alice Brown'.

Find regions that have no customers.

Find the region with the highest number of customers.

Find the region where 'Robert White' placed their orders.

Write a SQL query to find customers whose name contains ‘A’.

Retrieve customers whose total purchase value exceeds their credit limit.

Write a SQL query to find all customers who have not placed any orders.

Write a SQL query to count the number of customers who have a sales representative assigned.

Write a SQL query to find the difference between the highest and second highest order values.

Write a SQL query to calculate the total order value and total discount given to customers.

Write a SQL query to calculate the average order value and average discount per customer.

Write a SQL query to calculate the average order value for customers who have used a discount.

Write a SQL query to determine the minimum discount value, excluding NULLs.

Write a SQL query to find the total discount given to customers who joined after 2015.

Write a SQL query to find the latest registration date in the customers table.

Write a SQL query to find the average discount for customers who purchased ‘Electronics’, excluding NULLs.

Write a SQL query to determine the minimum order value for customers who joined in the 2000s.

Write a SQL query to find the total order value of customers whose names start with 'K'.

Write a SQL query to count the number of customers who joined in each year.

Write a SQL query to sum the total discount given to customers whose total purchase value is below $1500.

List customers who have not received any discounts but have placed orders worth more than $2500.

Find the average order total and number of orders per customer, ordered by average total in descending order.

List the total cost and order count per order status, excluding ‘Cancelled’ orders.

Show the total revenue per customer where total spending exceeds $5000, ordered by CustomerID.

Display the number of orders per status, sorted alphabetically by status.

Find the minimum and maximum order totals per customer, excluding customers with CustomerID 20.

List customers who have placed more than 3 orders, ordered by total spending in descending order.

Show the total quantity of products sold and the average unit price per product for products that have been ordered at least twice.

Retrieve all orders, ordered by OrderDate and TotalCost in descending order.

Find the total quantity of products ordered per product category, excluding a specific product (e.g., ProductID = 1).

List customers with an average order total above $2000, ordered by average spending.

Display the number of products sold and total revenue per customer for customers whose total spending exceeds $4000.

Show all orders sorted by CustomerID and then by OrderDate.

Find the average order total per product for all products except ProductID 10, ordered by product name.

List the total order value and order count per customer, excluding orders from customers named ‘John Doe’.

Retrieve the total revenue per product where the total revenue is less than $10,000, ordered by total revenue descending.

Show orders ordered by TotalCost descending and then by CustomerID ascending.

Find the maximum order total and order count per customer for customers who have placed more than 2 orders.

List the total revenue per customer, excluding CustomerID 40, ordered by total revenue.

Display the average order total and order count per customer, sorted by CustomerID and average order total descending.

Find customers with total spending greater than $3000, excluding orders with status ‘Pending’, ordered by total spending.


Retrieve the Name and Address of customers who have placed orders with a total cost greater than 2000 using INNER JOIN.

Retrieve all customers and their orders, including those who have not placed any orders, using LEFT JOIN.

List all ProductID, Name, and the number of times each product has been ordered, including products with no orders, using RIGHT JOIN.

Simulate a FULL OUTER JOIN to list all customers and their orders, including unmatched rows.

Find customers who have placed orders for at least one product more than once using a self-join.

Generate all possible customer-product combinations using CROSS JOIN.

List products that have been ordered at least once using EXISTS.

Find products that have never been ordered using NOT EXISTS.

Find customers and the total number of orders they have placed for products priced above 500 using JOIN and GROUP BY.

Retrieve all orders and their total costs, including those that have no associated products, using a simulated FULL JOIN.

List customer names and product names where the total cost of an order exceeds 5000 using INNER JOIN.

Retrieve category-wise total revenue and the number of orders placed using GROUP BY and JOIN.

List products that have never been ordered using RIGHT JOIN.

Combine customer and order data, including duplicates, using UNION ALL.

List orders and the names of the customers who placed them, including orders that have no associated customers, using LEFT JOIN.

Retrieve the average price of products per order using INNER JOIN and GROUP BY.

Find customers who have placed more than 3 orders using HAVING.

List customers and products where the order date is after January 1, 2020, using INNER JOIN.

Find products that have never been included in any order using LEFT JOIN and NULL check.

List customer names and their orders using an implicit join, ordered by customer name.
*/