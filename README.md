In This Project I have Used Criteria API to build Dynamic HQL Queries .

Project contents -->

Utility Class : HibernateUtil

Entity class : Product

Database name : vsbdb

Table name in SQL : Product


Tasks -->

i) select products from the table whose price is greater than 500

ii) select products from the table with quantities more than 10

iii) count no.of products available in the table

iv) select the product with lowest price

v) select the product with highest price

vi) calculate sum of prices of all products.


Output of the project --> 

Hibernate: select this_.slno as slno1_0_0_, this_.pname as pname2_0_0_, this_.price as price3_0_0_, this_.qty as qty4_0_0_ from Product this_

All Products List :

1 laptop 15 40000

2 Mobile 34 15000

3 earphone 8 700

4 modem 4 2500

5 simcard 30 200

6 datacard 34 100

7 battery 20 550

8 mobilecover 30 150

9 smartwatch 20 1000

10 tab 4 10000

11 mouse 12 700

12 charger 20 1000


---------------------------------

Products with price > 500 : 

Hibernate: select this_.slno as slno1_0_0_, this_.pname as pname2_0_0_, this_.price as price3_0_0_, this_.qty as qty4_0_0_ from Product this_ where this_.price>?

laptop

Mobile

earphone

modem

battery

smartwatch

tab

mouse

charger


---------------------------------

Products with Quantities > 10pcs

Hibernate: select this_.slno as slno1_0_0_, this_.pname as pname2_0_0_, this_.price as price3_0_0_, this_.qty as qty4_0_0_ from Product this_ where this_.qty>?

laptop

Mobile

simcard

datacard

battery

mobilecover

smartwatch

mouse

charger

---------------------------------

Hibernate: select count(*) as y0_ from Product this_ where this_.slno>?

No of products Available : 12

---------------------------------

Hibernate: select min(this_.price) as y0_ from Product this_

Lowest Amount Product 100

---------------------------------

Hibernate: select max(this_.price) as y0_ from Product this_

Highest Amount Product 40000

---------------------------------
Hibernate: select sum(this_.price) as y0_ from Product this_

Sum of All Product's Price : 71900

