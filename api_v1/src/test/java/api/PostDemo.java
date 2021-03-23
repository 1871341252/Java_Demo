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
		// ����Url
		String url = "http://192.168.50.11:8095/api/app/login";
		// ����get����
		HttpPost post = new HttpPost(url);
		// ��������ͷ
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		// post�����ñ���ʽ����
		post.setEntity(new StringEntity("username=18025381412&password=123456789"));
		// post������josn��ʽ����
		// post.setHeader("Content-Type","application/json");
		// post.setEntity(new
		// StringEntity("{\"username\":\"yangjie\",\"password\":\"123456789\"}"));
		// �����ͻ��ˣ����ڷ�������
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// ��¼��������ǰ��ʱ��
		long starttime = System.currentTimeMillis();
		// �ɿͻ��˷�������
		CloseableHttpResponse response = httpClient.execute(post);
		// ��¼����������ʱ��
		long endtime = System.currentTimeMillis();
		// ������Ӧ���body
		HttpEntity entity = response.getEntity();
		// ������Ӧ���״̬��
		int code = response.getStatusLine().getStatusCode();
		// ������Ӧ�������ͷ
		Header[] headers = response.getAllHeaders();
		// �����Ӧ�������ͷ
		System.out.println(EntityUtils.toString(entity));
		// �����Ӧ�������ͷ
		System.out.println(code);
		// �����Ӧ�������ͷ
		System.out.println(Arrays.toString(headers));
		// �����Ӧ�������ͷ
		System.err.println("�ӿ���Ӧʱ��Ϊ��" + (endtime - starttime) + "ms");
	}
}
