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
		// ����Url
		String url = "http://test.geron-e.com:8094/app/version/list?platAppId=01";
		// ����get����
		HttpGet get = new HttpGet(url);
		// ��������ͷ
		get.addHeader("Content-Type", "application/x-www-form-urlencoded");
		// �����ͻ��ˣ����ڷ�������
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// ���ô���fiddler��
		//HttpHost host=new HttpHost("127.0.0.1",8888);
		// ��¼��������ǰ��ʱ��
		long starttime = System.currentTimeMillis();
		// ���ô���������
		//CloseableHttpResponse response = httpClient.execute(host,get);
		// δ���ô���������
		CloseableHttpResponse response = httpClient.execute(get);
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
