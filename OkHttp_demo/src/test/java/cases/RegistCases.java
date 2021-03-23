package cases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import utils.HttpUtils;

public class RegistCases {
	@Test(dataProvider = "datas")
	public void testRegist(String params) {
		String url=Constants.REGIST_URL;
		String method=Constants.POST_METHOD;
		String body=HttpUtils.cell(method, url, params);
	}
	@DataProvider(name="datas")
	public Object[][] datas() {
		Object[][] datas= {
//				{"{\"username\":\"yangjie\",\"password\":\"123456789\"}"},
				{"username=yangjie&password=123456789"}
		};
		return datas;
	}
}
