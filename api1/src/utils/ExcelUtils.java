package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelUtils {
	public static void read() {
		//1.��ȡexcel��
		try {
			FileInputStream fisFileInputStream=new FileInputStream("src/data/�ӿڲ�������.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
