CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER(12, 2)
);

INSERT INTO Accounts VALUES (101, 1, 'Savings', 10000);
INSERT INTO Accounts VALUES (102, 2, 'Savings', 15000);
INSERT INTO Accounts VALUES (103, 3, 'Current', 8000);
INSERT INTO Accounts VALUES (104, 4, 'Savings', 20000);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Department VARCHAR2(50),
    Salary NUMBER(10, 2)
);

INSERT INTO Employees VALUES (1, 'Alice', 'Sales', 50000);
INSERT INTO Employees VALUES (2, 'Bob', 'HR', 45000);
INSERT INTO Employees VALUES (3, 'Charlie', 'Sales', 55000);
INSERT INTO Employees VALUES (4, 'David', 'IT', 60000);

SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to savings accounts.');
END;
/

EXEC ProcessMonthlyInterest;

SELECT * FROM Accounts;

