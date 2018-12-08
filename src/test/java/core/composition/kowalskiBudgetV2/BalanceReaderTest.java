package core.composition.kowalskiBudgetV2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

class BalanceReaderTest {

    private static final String FILE_PATH = "D:\\Projekty Java\\Programming2\\src\\main\\java\\core\\composition\\kowalskiBudgetV2\\budzet_kowalskich.xls";
    private static final int SHEET_NUMBER = 0;
    private static final int PROFIT_CELL = 1;
    private static final int OUTGOES_CELL = 3;

    @Test
    void read() throws IOException {
        BalanceReader reader = new BalanceReader();
        BalanceData data = reader.read(FILE_PATH, SHEET_NUMBER, PROFIT_CELL, OUTGOES_CELL);

        Assertions.assertEquals(
                data.getIncomes().size(), 3);

        Assertions.assertTrue(
                data.getIncomes()
                        .contains(new BigDecimal("20000.0")));

        Assertions.assertEquals(
                data.getOutcomes().size(), 16);

        Assertions.assertTrue(
                data.getOutcomes()
                        .contains(new BigDecimal("126.0")));
    }
}