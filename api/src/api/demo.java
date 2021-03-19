package api;

import java.util.Arrays;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.entity.mime.Header;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;


public class demo {
	public static void main(String[] args) throws Exception{
		String url="http://test.geron-e.com:8094/app/version/list?platAppId=01";
		HttpGet get=new HttpGet(url);
		get.addHeader("Content-Type","application/x-www-form-urlencoded");
		CloseableHttpClient httpClient=HttpClients.createDefault();
		CloseableHttpResponse response=httpClient.execute(get);
		HttpEntity entity=response.getEntity();
//		Header[] allHeaders=(Header[]) response.getHeaders();
		System.out.println(EntityUtils.toString(entity));
//		System.out.println(Arrays.toString(allHeaders));
	}

}
