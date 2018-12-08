package core.composition.kowalskiBudgetV2;

import java.math.BigDecimal;

public class BalanceCalculatorV2 {

    //przy BigDecimal nie możemy używać znaków matematycznych jak np + czy -, używamy dostępnych metod
    //musimy w pętlach zrobić przyrównanie i zastąpić zmienną na nową, ponieważ inaczej metoda add nie sumuje wyników
    BigDecimal calculate(BalanceData data) {
        BigDecimal result = BigDecimal.ZERO;

        //dodajemy przychody
        for(BigDecimal nextIncome : data.getIncomes()) {
            result = result.add(nextIncome);
        }

        //odejmujemy wydatki
        for(BigDecimal nextOutcome : data.getOutcomes()) {
            result = result.subtract(nextOutcome);
        }

        return result;
    }
}
