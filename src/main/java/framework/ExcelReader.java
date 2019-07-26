package framework;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	
	@SuppressWarnings("static-access")
	public static Object[] readExcelData(String excelFileName,
			String wSheetName, String parentKey) {
		try {
			// get input Stream
			InputStream is = ClassLoader.getSystemClassLoader()
					.getSystemResourceAsStream(excelFileName);
			// Create the object of workbook

			XSSFWorkbook excelFile = new XSSFWorkbook(is);
			// get The worksheet
			XSSFSheet workSheet = excelFile.getSheet(wSheetName);

			int noOfRows = workSheet.getLastRowNum();
			int noOfCol = workSheet.getRow(0).getLastCellNum();

			Object[] tempData = new Object[noOfCol];

			
			for (int i = 0; i < noOfRows; i++) {

				XSSFRow row = workSheet.getRow(i + 1);
				boolean isKey = false;
				try{
					isKey = row.getCell(0).getStringCellValue().equals(parentKey);
				}catch(IllegalStateException ise){
					isKey = cellToObject(row.getCell(0)).toString().equals(parentKey);
				}
				if(isKey) {
				
					for (int j = 0; j < noOfCol; j++) {
						XSSFCell cell = row.getCell(j);
						Object value = cellToObject(cell);
						tempData[j] = value;
					}
					return tempData;
				}
				
			}
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}
	
	@SuppressWarnings("static-access")
	public static void writeToExcel(Object[] data) {
		try {
			// Input stream
			InputStream is = ClassLoader.getSystemClassLoader().getSystemResourceAsStream("outputUserData.xlsx");

			XSSFWorkbook excelFile = new XSSFWorkbook(is);
			// get The worksheet
			XSSFSheet workSheet = excelFile.getSheet("AAData"); // sheet name
			
			int lastRowNum = workSheet.getLastRowNum();
			
			Row rowCreated  = workSheet.createRow(lastRowNum + 1);
			
			int cellNum = 0;
			
			for (Object item : data) {
				org.apache.poi.ss.usermodel.Cell cell = rowCreated.createCell(cellNum++);
				 if (item instanceof String) {
                     cell.setCellValue((String) item);
                 } else if (item instanceof Boolean) {
                     cell.setCellValue((Boolean) item);
                 } else if (item instanceof Date) {
                     cell.setCellValue((Date) item);
                 } else if (item instanceof Double) {
                     cell.setCellValue((Double) item);
                 }
			}
			
            // open an OutputStream to save written data into XLSX file
            FileOutputStream os = new FileOutputStream("/home/ravi/Desktop/workspace/TAAS/dataoutputUserData.xlsx");
            excelFile.write(os);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private static Object cellToObject(XSSFCell cell) {
		int type;
		Object result;
		if (cell == null) {
			return null;
		}
		type = cell.getCellType();

		switch (type) {
		case XSSFCell.CELL_TYPE_NUMERIC: // 0
			cell.setCellType(XSSFCell.CELL_TYPE_STRING);
			// result = cell.getNumericCellValue();
			result = cell.getStringCellValue();

			if ("-".equals((String) result)) {
				result = null;
			}
			break;
		case XSSFCell.CELL_TYPE_STRING: // 1
			result = cell.getStringCellValue();
			break;
		case XSSFCell.CELL_TYPE_FORMULA: // 2
			throw new RuntimeException("We can't evaluate formulas in Java");
		case XSSFCell.CELL_TYPE_BLANK: // 3
			result = null;
			break;
		case XSSFCell.CELL_TYPE_BOOLEAN: // 4
			result = cell.getBooleanCellValue();
			break;
		case XSSFCell.CELL_TYPE_ERROR: // 5
			throw new RuntimeException("This cell has an error");
		default:
			throw new RuntimeException("We don't support this cell type: "
					+ type);
		}
		return result;
	}

	public static Object getCellData(Object[][] dataObj, int index) {
		int noRows = dataObj.length;
		int noOfCols = dataObj[0].length;
		
		for (int i = 0; i < noRows; i++) {
			for (int j = 0; j < noOfCols; j++) {
				if(dataObj[i][j]!=null && j==index) {
					return dataObj[i][j];
				}
			}
		}
		return null;
	}

}
