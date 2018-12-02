package core.kowalskiBudget;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BalanceCalculator {
    private static final String FILE_PATH = "D:\\Projekty Java\\Programming2\\src\\main\\java\\core\\kowalskiBudget\\budzet_kowalskich.xls";

    public static void main(String[] args) throws IOException, InvalidFormatException {
        System.out.println("Budżet Kowalskich wynosi: " + readExcel(FILE_PATH) + " zł");
    }

    //row - wiersz
    //cell - kolumna
    private static double readExcel(String filePath) throws IOException, InvalidFormatException {
        try (InputStream stream = new FileInputStream(filePath)) {
            Workbook workbook = WorkbookFactory.create(stream);
            Sheet sheet = workbook.getSheetAt(0);

            double profit = 0;
            double outgoes = 0;
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cell1 = row.getCell(1);
                Cell cell3 = row.getCell(3);

                if (cell1.getNumericCellValue() != 0) {
                    System.out.println("Dochód: " + cell1.getNumericCellValue());
                    profit += cell1.getNumericCellValue();
                }

                if (cell3.getNumericCellValue() != 0) {
                    System.out.println("Wydatek: " + cell3.getNumericCellValue());
                    outgoes += cell3.getNumericCellValue();
                }
            }

            return profit - outgoes;
        }
    }
}
