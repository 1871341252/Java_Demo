package runapi;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excledata.RangeDataPOI;
import utils.HttpUtils;

public class Run {
	@Test(dataProvider = "datas")
	// 如果数据在其他类
	// @Test(dataProviderClass = "写入其他类的路径")
	public void testlogin(String url, String params) throws Exception {
		HttpUtils.formPost(url, params);
//		System.out.println(datas());
	}

	@DataProvider(name = "datas")
	public Object[][] datas() throws IOException {
//		Object[][] datas= {
//			{"http://192.168.50.11:8095/api/app/login",
//				"username=18025381412&password=123456789"},
//			{"http://192.168.50.11:8095/api/app/login",
//				"username=15192860615&password=888888"},
//			{"http://192.168.50.11:8095/api/app/login",
//				"username=18660953805&password=888888"}
//		};
		Object[][] datas = RangeDataPOI.rangeData("src\\test\\resources\\data\\aaa.xlsx", "Sheet1");
		return datas;
	}
}
