package ForDebugTest;


import org.testng.annotations.Test;
import utilities.ExceptionMsg;
import utilities.datahandler.ExcelDataFile;

import java.io.IOException;

import utilities.datahandler.ExcelDataFile.*;


public class TestExcelFile {

    ExcelDataFile excelDataFile = new ExcelDataFile();
    @Test
    public void getValueInExcelFile() {
        System.out.println("Get value in a specific cell excel file");
        try {
            excelDataFile.getDataInACellExcelFile("UserInformation", "Sheet1", 1, 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExceptionMsg exceptionMsg) {
            exceptionMsg.printStackTrace();
        }
    }
    @Test
    public void getValuesInExcelFile() {
        try {
            System.out.println("Get values in an excel file");
            excelDataFile.getDataInExcelFile("UserInformation", "Sheet1", 11);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExceptionMsg exceptionMsg) {
            exceptionMsg.printStackTrace();
        }
    }
}