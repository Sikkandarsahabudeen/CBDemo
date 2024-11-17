package utilities;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public static List<String[]> readExcel(String filePath, String sheetName) throws Exception {
        List<String[]> data = new ArrayList<>();
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);

        for (Row row : sheet) {
            int cellCount = row.getLastCellNum();
            String[] rowData = new String[cellCount];
            for (int i = 0; i < cellCount; i++) {
                Cell cell = row.getCell(i);
                rowData[i] = cell != null ? cell.toString() : "";
            }
            data.add(rowData);
        }
        workbook.close();
        return data;
    }
}
