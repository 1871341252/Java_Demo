package excledata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class RangeData {
	public static Object[][] rangeData(String filepath) throws BiffException, IOException {
		String[][] array = null;
		InputStream fs = null;
		Workbook wb = null;
		fs = new FileInputStream(filepath);
		wb = Workbook.getWorkbook(fs);
		int col = 0;
		int row = 0;
		Sheet[] sheets = wb.getSheets();
		Sheet sheet = sheets[0];
		array = new String[sheet.getRows() - 1][sheet.getColumns()];
		Cell cell = null;
		for (int j = 1; j < sheet.getRows(); j++) {
			col = 0;
			for (int k = 0; k < sheet.getColumns(); k++) {
				cell = sheet.getCell(k, j);
				array[row][col] = cell.getContents();
				col++;
			}
			row++;
		}
		return array;
	}

	public static void main(String[] args) throws BiffException, IOException {
		Object[][] array1 = rangeData("src/test/resources/TestData.xls");
//		System.out.println(array1);
		for (int i = 0; i < array1.length; i++) {// ����ÿ��һά����
			for (int j = 0; j < array1[0].length; j++) {// ����ÿ��һά�����е�Ԫ��
				System.out.print(array1[i][j] + " ");// ���ÿ��Ԫ�ص�ֵ
			}
			System.out.println();// ÿִ����һ��һά���黻��
		}
	}
}
