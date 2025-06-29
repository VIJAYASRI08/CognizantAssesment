CREATE TABLE Employees (
  employee_id INT,
  department_id INT,
  salary FLOAT
);

INSERT INTO Employees VALUES (101, 1, 10000);
INSERT INTO Employees VALUES (102, 1, 8000);
INSERT INTO Employees VALUES (103, 2, 9000);

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_dept_id IN INT,
  p_bonus IN FLOAT
) IS
BEGIN
  UPDATE Employees
  SET salary = salary + (salary * p_bonus / 100)
  WHERE department_id = p_dept_id;

  DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus || '% applied to department ID ' || p_dept_id);
  COMMIT;
END;
/

EXEC UpdateEmployeeBonus(1,10);

SELECT * FROM Employees;

