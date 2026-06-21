CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_empId NUMBER,
    p_percent NUMBER
)
IS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_count
    FROM Employees
    WHERE EmployeeID = p_empId;
    IF v_count = 0 THEN
        RAISE_APPLICATION_ERROR(
            -20002,
            'Employee Not Found'
        );
    END IF;
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmployeeID = p_empId;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary Updated');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/