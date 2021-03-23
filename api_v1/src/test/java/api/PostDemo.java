package api;

import java.io.IOException;
import java.util.Arrays;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PostDemo {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// 定义Url
		String url = "http://192.168.50.11:8095/api/app/login";
		// 创建get请求
		HttpPost post = new HttpPost(url);
		// 传入请求头
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		// post请求用表单形式传参
		post.setEntity(new StringEntity("username=18025381412&password=123456789"));
		// post请求用josn形式传参
		// post.setHeader("Content-Type","application/json");
		// post.setEntity(new
		// StringEntity("{\"username\":\"yangjie\",\"password\":\"123456789\"}"));
		// 创建客户端（用于发送请求）
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 记录发送请求前的时间
		long starttime = System.currentTimeMillis();
		// 由客户端发送请求
		CloseableHttpResponse response = httpClient.execute(post);
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
