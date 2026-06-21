CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loanAmount NUMBER,
    p_interestRate NUMBER,
    p_years NUMBER
)
RETURN NUMBER
IS
    v_total NUMBER;
    v_monthly NUMBER;
BEGIN
    v_total :=
       p_loanAmount +
       (p_loanAmount * p_interestRate * p_years / 100);
    v_monthly :=
       v_total / (p_years * 12);
    RETURN ROUND(v_monthly,2);
END;
/