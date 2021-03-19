package utils;

import java.io.IOException;
import java.util.Arrays;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtils {
	public static void allGet(String url) throws ClientProtocolException, IOException {
		HttpGet get = new HttpGet(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		long starttime = System.currentTimeMillis();
		CloseableHttpResponse response = httpClient.execute(get);
		long endtime = System.currentTimeMillis();
		HttpEntity entity = response.getEntity();
		int code = response.getStatusLine().getStatusCode();
		Header[] headers = response.getAllHeaders();
		System.out.println(EntityUtils.toString(entity));
		System.out.println(code);
		System.out.println(Arrays.toString(headers));
		System.err.println("接口相应时间为：" + (endtime - starttime) + "ms");
	}
	public static void formPost(String url,String params) throws ClientProtocolException, IOException {
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		post.setEntity(new StringEntity(params));
		CloseableHttpClient httpClient = HttpClients.createDefault();
		long starttime = System.currentTimeMillis();
		CloseableHttpResponse response = httpClient.execute(post);
		long endtime = System.currentTimeMillis();
		HttpEntity entity = response.getEntity();
		int code = response.getStatusLine().getStatusCode();
		Header[] headers = response.getAllHeaders();
		System.out.println(EntityUtils.toString(entity));
		System.out.println(code);
		System.out.println(Arrays.toString(headers));
		System.err.println("接口相应时间为：" + (endtime - starttime) + "ms");
	}
	public static void josnPost(String url,String params) throws ClientProtocolException, IOException {
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/json");
		post.setEntity(new StringEntity(params));
		CloseableHttpClient httpClient = HttpClients.createDefault();
		long starttime = System.currentTimeMillis();
		CloseableHttpResponse response = httpClient.execute(post);
		long endtime = System.currentTimeMillis();
		HttpEntity entity = response.getEntity();
		int code = response.getStatusLine().getStatusCode();
		Header[] headers = response.getAllHeaders();
		System.out.println(EntityUtils.toString(entity));
		System.out.println(code);
		System.out.println(Arrays.toString(headers));
		System.err.println("接口相应时间为：" + (endtime - starttime) + "ms");
	}
	public static void main(String[] args) throws Exception {
		String url="http://118.24.255.132:2333/gethighusers?num=10";
		String url1="http://192.168.50.11:8095/api/app/login";
		String params1="username=18025381412&password=123456789";
		String url2="http://118.24.255.132:2333/login";
		String params2="{\"username\":\"yangjie\",\"password\":\"123456789\"}";
		allGet(url);
		formPost(url1, params1);
		josnPost(url2, params2);
	}
}
