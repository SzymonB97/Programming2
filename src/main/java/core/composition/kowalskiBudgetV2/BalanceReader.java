package core.composition.kowalskiBudgetV2;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

public class BalanceReader {

    BalanceData read(String filePath, int sheetNumber, int profitCell, int outgoesCell) throws IOException {

        BalanceData result = new BalanceData();
        try (InputStream inp = new FileInputStream(filePath)) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(sheetNumber);

            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                BigDecimal income = getCellValue(row, profitCell);
                BigDecimal outcome = getCellValue(row, outgoesCell);

                if (!income.equals(BigDecimal.ZERO)) {
                    result.getIncomes().add(income);
                }

                if (!outcome.equals(BigDecimal.ZERO)) {
                    result.getOutcomes().add(outcome);
                }
            }

            return result;
        }
    }

    private BigDecimal getCellValue(Row row, int columnNumber) {
        Cell cell = row.getCell(columnNumber);
        return !cell.toString().isEmpty() ?
                new BigDecimal(cell.toString()) : BigDecimal.ZERO;
    }
}
