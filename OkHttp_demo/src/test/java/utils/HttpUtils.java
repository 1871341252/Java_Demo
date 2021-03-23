package utils;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtils {
	public static String get(String url,String params){
		OkHttpClient client = new OkHttpClient();
		Request request=new Request.Builder().url(url+"?"+params).get().build();
		try {
			Response response=client.newCall(request).execute();
			System.out.println(response.code());
			System.out.println(response.headers());
			String body=response.body().string();
			System.out.println(body);
			return body;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String post(String url,String params){
		OkHttpClient client=new OkHttpClient();
		MediaType JSON = MediaType.parse("application/json;charset=utf-8");
		RequestBody requestBody=RequestBody.create(JSON, String.valueOf(params));
		try {
			Request request=new Request.Builder().url(url).post(requestBody).build();
			Response response=client.newCall(request).execute();
			System.out.println(response.code());
			System.out.println(response.headers());
			String body=response.body().string();
			System.out.println(body);
			return body;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String cell(String method,String url,String params) {
		if ("get".equalsIgnoreCase(method)) {
			return get(url, params);
		}else if ("post".equalsIgnoreCase(method)) {
			return post(url, params);
		}
		return null;
	}
}
