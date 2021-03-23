package okhttp;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpPost {

	public static void main(String[] args) throws IOException {
		String url="http://test.geron-e.com:8095/api/app/login";
		OkHttpClient client=new OkHttpClient();
		MediaType type=MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body=RequestBody.create(type, "username=18660953805&password=888888");
		Request request=new Request.Builder().url(url).post(body).build();
		Response response=client.newCall(request).execute();
		System.out.println(response.code());
		System.out.println(response.headers());
		System.out.println(response.body().string());
	}
}
