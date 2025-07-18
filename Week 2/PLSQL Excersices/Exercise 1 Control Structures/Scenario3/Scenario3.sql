CREATE TABLE Customers (
    ID           NUMBER PRIMARY KEY,
    Name         VARCHAR2(50),
    Age          NUMBER,
    Balance      NUMBER(10, 2),
    IsVIP        VARCHAR2(5) DEFAULT 'FALSE'
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER(5, 2),
    DueDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(ID)
);

INSERT INTO Customers VALUES (1, 'John Smith', 65, 12000.00, 'FALSE');
INSERT INTO Customers VALUES (2, 'Mary Johnson', 45, 8000.00, 'FALSE');
INSERT INTO Customers VALUES (3, 'Robert Brown', 70, 15000.00, 'FALSE');
INSERT INTO Customers VALUES (4, 'Emily Davis', 30, 9500.00, 'FALSE');
INSERT INTO Customers VALUES (5, 'Michael Wilson', 62, 11000.00, 'FALSE');

INSERT INTO Loans VALUES (101, 1, 8.5, SYSDATE + 20);
INSERT INTO Loans VALUES (102, 2, 9.0, SYSDATE + 40);
INSERT INTO Loans VALUES (103, 3, 7.5, SYSDATE + 10);
INSERT INTO Loans VALUES (104, 4, 9.2, SYSDATE + 5);

DECLARE
    CURSOR cur_loans IS
        SELECT CustomerID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR rec IN cur_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ID ' || rec.CustomerID || ' has a loan due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
    END LOOP;
END;

