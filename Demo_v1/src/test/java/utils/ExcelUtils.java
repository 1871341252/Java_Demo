package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	public static void main(String[] args) {
		read();
	}
	public static void read() {
		FileInputStream fis=null;
		//1.读取excel表
		try {
			fis=new FileInputStream("src/test/resources/TestData.xls");
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet=workbook.getSheet("Cases");
			int lastRowNum = sheet.getLastRowNum();
			for (int i = 1; i <= lastRowNum; i++) {
				Row row = sheet.createRow(i);
				//获取url
				Cell cell=row.getCell(3);
				Cell urlcell = row.getCell(2,MissingCellPolicy.CREATE_NULL_AS_BLANK);
				urlcell.setCellType(CellType.STRING);
				String urlCellValue = urlcell.getStringCellValue();
				//获取type
//				Cell typecell = row.getCell(4,MissingCellPolicy.CREATE_NULL_AS_BLANK);
//				typecell.setCellType(CellType.STRING);
//				String typeCellValue = typecell.getStringCellValue();
//				//获取content-type
//				Cell contenttypecell = row.getCell(5,MissingCellPolicy.CREATE_NULL_AS_BLANK);
//				contenttypecell.setCellType(CellType.STRING);
//				String contenttypeCellValue = contenttypecell.getStringCellValue();
//				//获取params
//				Cell paramscell = row.getCell(6,MissingCellPolicy.CREATE_NULL_AS_BLANK);
//				paramscell.setCellType(CellType.STRING);
//				String paramsCellValue = paramscell.getStringCellValue();
//				System.out.println(lastRowNum);
//				System.out.println(urlcell);
//				System.out.println(cell);
				System.out.println(urlCellValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
