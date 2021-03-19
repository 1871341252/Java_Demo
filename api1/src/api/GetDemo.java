package api;

import java.util.Arrays;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetDemo {
	public static void main(String[] args) throws Exception {
		// 定义Url
		String url = "http://test.geron-e.com:8094/app/version/list?platAppId=01";
		// 创建get请求
		HttpGet get = new HttpGet(url);
		// 传入请求头
		get.addHeader("Content-Type", "application/x-www-form-urlencoded");
		// 创建客户端（用于发送请求）
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 设置代理（fiddler）
		//HttpHost host=new HttpHost("127.0.0.1",8888);
		// 记录发送请求前的时间
		long starttime = System.currentTimeMillis();
		// 设置代理发送请求
		//CloseableHttpResponse response = httpClient.execute(host,get);
		// 未设置代理发送请求
		CloseableHttpResponse response = httpClient.execute(get);
		// 记录发送请求后的时间
		long endtime = System.currentTimeMillis();
		// 接收响应体的body
		HttpEntity entity = response.getEntity();
		// 接收响应体的状态码
		int code = response.getStatusLine().getStatusCode();
		// 接收响应体的请求头
		Header[] headers = response.getAllHeaders();
		// 输出响应体的请求头
		System.out.println(EntityUtils.toString(entity));
		// 输出响应体的请求头
		System.out.println(code);
		// 输出响应体的请求头
		System.out.println(Arrays.toString(headers));
		// 输出响应体的请求头
		System.err.println("接口相应时间为：" + (endtime - starttime) + "ms");
	}
}
