package core.composition.kowalskiBudgetV2;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {

    private static final String FILE_PATH = "D:\\Projekty Java\\Programming2\\src\\main\\java\\core\\composition\\kowalskiBudgetV2\\budzet_kowalskich.xls";
    private static final int SHEET_NUMBER = 0;
    private static final int PROFIT_CELL = 1;
    private static final int OUTGOES_CELL = 3;

    public static void main(String[] args) throws IOException {
        BalanceReader readExcel = new BalanceReader();
        BalanceData data = readExcel.read(FILE_PATH, SHEET_NUMBER, PROFIT_CELL, OUTGOES_CELL);

        BalanceCalculatorV2 calculator = new BalanceCalculatorV2();
        BigDecimal balance = calculator.calculate(data);

        System.out.println("Saldo wynosi: " + balance + "zł");
    }
}
