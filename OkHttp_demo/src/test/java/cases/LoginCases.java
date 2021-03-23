package cases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import utils.HttpUtils;

public class LoginCases {
	@Test(dataProvider = "datas")
	public void testRegist(String params) {
		String url=Constants.LOGIN_URL;
		String method=Constants.GET_METHOD;
		String body=HttpUtils.cell(method, url, params);
		boolean flag=body.contains("登录成功");
		System.out.println("断言结果："+flag);
		Assert.assertEquals(flag, true);
	}
	@DataProvider(name="datas")
	public Object[][] datas() {
		Object[][] datas= {
		{"username=18025381412&password=123456789"}
		};
		return datas;
	}
}
