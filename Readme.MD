## Scope
This project demonstrates the different strategies for mapping Inheritance in Hibernate

There are four different Strategies
- Single Table
- Table per Class
- Joined table
- Mapped Superclass


## Single Table
The inheritance tree maps to a single table.
Table has columns for all fields in the inheritance tree.
We use a discriminator column that indicates what class or type of data 
are stored in a given row. We expect some columns to have NULL value.
#### Pros
- Simple and straight-forward implementation
- Best Query Performance (since a single table stores all data)
#### Cons
- A subset of fields is being used per row
- Nullable fields can cause "data-integrity" issues

## Table per Class
We have one table per class for the concrete classes. 
The tables have only the related fields, no extra columns exist.
This strategy requires a "sequence" table to generate a unique Id across the tables.
#### Pros
- Simple and straight-forward implementation
- Good Query Performance on sub-classes
#### Cons
- Slow Query Performance on super-class (due to many Joins)
- Query Performance slows down for very deep inheritance trees
- Id Generation with sequence tables in a hign-volume multi-threaded Envs is slow

## Joined table
We model the inheritance by joining on the primary and foreign keys. 
The superclass has the primary key, while the concreted classes have the foreign key.
#### Pros
- Normalized Database model
- No duplicate mapping of inherited fields
#### Cons
- Slow Query Performance on super-class (due to many Joins)
- Query Performance slows down for very deep inheritance trees

## Mapped Superclass
Superclass just defines the common fields, Superclass is not an Entity. 
Only subclasses have tables in DB.
#### Pros
- Simple and straight-forward implementation
- Good Query Performance on sub-classes (no need for Joins)
#### Cons
- No direct support for polymorphic queries (Need to manually code HQL joins) 
- Slow Query Performance on super-class (due to many Joins)


## What to Select
- Best Performance with queries and 'write' operations => Single table
- Good Performance for queries of subclassses and data integrity =>  Table per Class or Mapped superclass
- Normalized database and data integrity => Joined table

### Constraints/Dependencies
- complexity of inheritance tree
- number of rows in DB
- database tuning
- application requirements

## Comparison (Scale of 1 - 4, 4 is the best)
Goal/Strategy | Single table | Table per class | Joined table | Mapped superclass 
--- | --- | --- | --- |--- 
Performance: write operations - insert/update/delete | 4 | 3 | 1 | 4 
Performance: query concrete subclasses | 4 | 4 | 1 | 4 
Performance: polymorphic query | 4 | 1 | 1 | 1 
Normalized database design | 1 | 3 | 3 | 3 
Data Integrity (supports not NULL column constraints) | 1 | 3 | 3 | 4 
