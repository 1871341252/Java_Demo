package testng_demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo4 {
	@Test(dataProvider = "datas")
	public void test5(String l1,String l2) {
		System.out.println(l1);
		System.out.println(l2);
		
	}
	@DataProvider(name = "datas")
	public Object[][] datas() {
		Object[][] datas= {
				{"http://192.168.50.11:8095/api/app/login",
				"username=18025381412&password=123456789"},
				{"http://192.168.50.11:8095/api/app/login",
				"username=15192860615&password=888888"}
				};
		return datas;
	}
}
