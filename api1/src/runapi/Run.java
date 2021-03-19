package runapi;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.HttpUtils;

public class Run {
	@Test(dataProvider = "datas")
	//如果数据在其他类
	//@Test(dataProviderClass = "写入其他类的路径")
	public void testlogin(String url,String params) throws Exception {
		//String url="http://192.168.50.11:8095/api/app/login";
		//String params="username=18025381412&password=123456789";
		HttpUtils.formPost(url, params);
	}
	@DataProvider(name = "datas")
	public Object[][] datas() {
		Object[][] datas= {
			{"http://192.168.50.11:8095/api/app/login",
				"username=18025381412&password=123456789"},
			{"http://192.168.50.11:8095/api/app/login",
				"username=15192860615&password=888888"},
			{"http://192.168.50.11:8095/api/app/login",
				"username=18660953805&password=888888"}
		};
		return datas;
	}
}
