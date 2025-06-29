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

CREATE OR REPLACE PROCEDURE TransferFunds(
    from_account IN NUMBER,
    to_account IN NUMBER,
    amount IN NUMBER
) IS
    from_balance NUMBER;
BEGIN
    SELECT Balance INTO from_balance 
    FROM Accounts 
    WHERE AccountID = from_account 
    FOR UPDATE;

    IF from_balance < amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - amount
    WHERE AccountID = from_account;

    UPDATE Accounts
    SET Balance = Balance + amount
    WHERE AccountID = to_account;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || amount || ' from Account ' || from_account || ' to Account ' || to_account);
END;
/

BEGIN
    TransferFunds(101, 102, 2000);
END;
/

SELECT * FROM Accounts;

SELECT * FROM Employees;

