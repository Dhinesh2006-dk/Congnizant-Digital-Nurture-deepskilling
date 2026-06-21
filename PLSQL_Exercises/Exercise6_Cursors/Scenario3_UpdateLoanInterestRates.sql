DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID,
               InterestRate
        FROM Loans;
BEGIN
    FOR rec IN UpdateLoanInterestRates
    LOOP
        UPDATE Loans
        SET InterestRate = rec.InterestRate + 1
        WHERE LoanID = rec.LoanID;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE(
        'Loan Interest Rates Updated'
    );
END;
/