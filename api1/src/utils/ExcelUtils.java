package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelUtils {
	public static void read() {
		//1.读取excel表
		try {
			FileInputStream fisFileInputStream=new FileInputStream("src/data/接口测试用例.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
