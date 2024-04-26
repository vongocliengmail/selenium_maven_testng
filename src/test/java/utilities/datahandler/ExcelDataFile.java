package utilities.datahandler;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.ExceptionMsg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataFile {
    public static String cellValue;
    /* Method excel Read excel
     * @param browser
     * @returns String
     **/

    public static String getDataInACellExcelFile(String FileName, String SheetName, int rowNumber, int columnNumber)
            throws IOException, ExceptionMsg {
        try {
            File file = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/excel/" + FileName + ".xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            Workbook excelHandlingBook = new XSSFWorkbook(inputStream);
            Sheet sheetDetails = excelHandlingBook.getSheet(SheetName);
            Row rowDetails = sheetDetails.getRow(rowNumber);
            if (rowDetails == null) {
                System.out.println("No data present in the Row, please check the cell coordinates are proper?");
                return "";
            } else {
                Cell cellDetails = rowDetails.getCell(columnNumber);
                if (cellDetails == null) {
                    System.out.println("No data present in the cell, please check the cell coordinates are proper?");
                    return "";
                }
                cellValue = rowDetails.getCell(columnNumber).getStringCellValue();
                System.out.println("Data in the required cell is = " + cellValue);
                inputStream.close();
            }
        } catch (Exception e) {
            throw new ExceptionMsg("Error while reading the excel");
        }
        return cellValue;
    }

    /* Method excel Read excel
     * @param filename
     **/

    public void getDataInExcelFile(String FileName, String SheetName, int columnNumber)
            throws IOException, ExceptionMsg {
        int rowNumber = 0;
        try {
            File file = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/excel/" + FileName + ".xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            Workbook excelHandlingBook = new XSSFWorkbook(inputStream);
            Sheet sheetDetails = excelHandlingBook.getSheet(SheetName);
            Row rowDetails;
            rowNumber = sheetDetails.getLastRowNum();
            System.out.println(rowNumber);
            int j = 0;
            int i=0;
            DataFormatter dataFormatter= new DataFormatter();
            if ((rowNumber != 0) && (columnNumber > 0)) {
                for (i = 1; i < rowNumber+1; i++) {
                    for (j = 0; j < columnNumber; j++) {
                        rowDetails = sheetDetails.getRow(i);
                        cellValue = dataFormatter.formatCellValue(rowDetails.getCell(j));
                        System.out.println("Data in the specific cell is = " + cellValue);
                    }
                }
            }
            inputStream.close();
        } catch (Exception e) {
            throw new ExceptionMsg("Error while reading the excel");
        }

    }
}
