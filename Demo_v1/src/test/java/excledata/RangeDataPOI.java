package excledata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RangeDataPOI {
	public static Object[][] rangeData(String filepath, String sheetname) throws IOException {
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = null;
		Sheet sheet = null;
		String extensionName = filepath.substring(filepath.indexOf("."));
		if (extensionName.equals(".xls")) {
			workbook = new HSSFWorkbook(fis);
		} else if (extensionName.equals(".xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else {
			System.err.println("�ļ��ĸ�ʽ����ȷ��");
		}
		for (int l = 0; l < workbook.getNumberOfSheets(); l++) {
			sheet = workbook.getSheetAt(l);
			if (sheet.getSheetName().equals(sheetname)) {
				break;
			} else {
				// ����������ʱȡ���һ�ű�
				continue;
			}
		}
		// Sheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		List<Object[]> records = new ArrayList<Object[]>();
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			String fields[] = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// �˴�ֻ��ȡ�ַ������ͣ���������������򱨴�
				fields[j] = row.getCell(j).getStringCellValue();
			}
			records.add(fields);
		}
		Object[][] results = new Object[records.size()][];
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		return results;
	}

	public static void main(String[] args) throws IOException {
		Object[][] array1 = rangeData("src\\test\\resources\\data\\aaa.xlsx", "Cases1");
//		for (int i = 0; i < array1.length; i++) {// ����ÿ��һά����
//			for (int j = 0; j < array1[0].length; j++) {// ����ÿ��һά�����е�Ԫ��
//				System.out.print(array1[i][j] + " ");// ���ÿ��Ԫ�ص�ֵ
//			}
//			System.out.println();// ÿִ����һ��һά���黻��
//		}
	}
}
