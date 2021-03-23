package okhttp;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpGet {

	public static void main(String[] args) throws IOException {
		String url="http://test.geron-e.com:8094/app/version/list?platAppId=01";
		OkHttpClient client=new OkHttpClient();
		Request request=new Request.Builder().url(url).get().build();
		Response response=client.newCall(request).execute();
		System.out.println(response.code());
		System.out.println(response.headers());
		System.out.println(response.body().string());
	}
}
