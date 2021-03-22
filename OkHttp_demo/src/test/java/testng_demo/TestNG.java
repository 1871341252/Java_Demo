package testng_demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG {
	//dependsOnMethods属性代表依赖关系
	//alwaysRun代表依赖的前一个方法错误后一个方法是否继续执行
	//description对方法的说明
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
	//enabled此属性可直接跳过该方法
	@Test(enabled = false)
	public void test3() {
		System.out.println("start test2");
		Assert.assertEquals(false, true);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
}
