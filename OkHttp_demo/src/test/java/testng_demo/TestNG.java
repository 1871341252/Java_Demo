package testng_demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG {
	//dependsOnMethods���Դ���������ϵ
	//alwaysRun����������ǰһ�����������һ�������Ƿ����ִ��
	//description�Է�����˵��
	@Test(dependsOnMethods = "test2",alwaysRun = true,description = "test....")
	public void test1() {
		System.out.println("start test1");
		Assert.assertEquals(false, true);
	}
	@Test
	public void test2() {
		System.out.println("start test2");
		Assert.assertEquals(false, true);
	}
	//enabled�����Կ�ֱ�������÷���
	@Test(enabled = false)
	public void test3() {
		System.out.println("start test2");
		Assert.assertEquals(false, true);
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}
}
