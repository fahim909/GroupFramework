package TestData;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader2 {

    public static String Path = "/Users/junedalam/Documents/July2018WebAutomation/Expedia/src/test/java/Tests/TestFiles/ExpediaTestData.xls";
    static Workbook book;
    static Sheet sheet;
    static String [] parsedData;

        public static Object[][] getTestData(int sheetIndex){
        //FileInputStream file = null;
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(Path));
            //file = new FileInputStream(Path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            try {
                book = WorkbookFactory.create(bis);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
            sheet = book.getSheetAt(sheetIndex);
            //Object[][] data = new  Object[sheet.getLastRowNum()+1][sheet.getRow(0).getLastCellNum()+1];
            Object [][] parsedData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            for (int i = 0;i<parsedData.length;i++){
                for (int k = 0; k < sheet.getRow(i).getLastCellNum();k++){
                    parsedData[i][k] = sheet.getRow(i+1).getCell(k).toString();
                }
            }
        return parsedData;
    }

//    public static String[][] getTestData2(int sheetIndex){
//        //FileInputStream file = null;
//        BufferedInputStream bis = null;
//        try {
//            bis = new BufferedInputStream(new FileInputStream(Path));
//            //file = new FileInputStream(Path);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            book = WorkbookFactory.create(bis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//        }
//        sheet = book.getSheetAt(sheetIndex);
//        String [][] parsedData = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//        for (int i = 0;i<parsedData.length;i++){
//            for (int k = 1; k < sheet.getRow(i).getLastCellNum();k++){
//                parsedData[i][k] = sheet.getRow(i+1).getCell(k).toString();
//            }
//        }
//        return parsedData;
//    }
public static String[] getTestData2(int sheetIndex){
    //FileInputStream file = null;
    BufferedInputStream bis = null;
    try {
        bis = new BufferedInputStream(new FileInputStream(Path));
        //file = new FileInputStream(Path);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    try {
        book = WorkbookFactory.create(bis);
    } catch (IOException e) {
        e.printStackTrace();
    } catch (InvalidFormatException e) {
        e.printStackTrace();
    }
    sheet = book.getSheetAt(sheetIndex);
     parsedData = new String[sheet.getLastRowNum()];
    for (int i = 1;i<parsedData.length;i++){
            parsedData[i] = sheet.getRow(i).getCell(2).toString();
    }
    return parsedData;
  }
}

