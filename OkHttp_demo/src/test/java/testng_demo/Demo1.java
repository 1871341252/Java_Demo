package testng_demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo1 {
	
	@BeforeSuite
	public void f1() {
		System.out.println("BeforeSuite");
	}
	
	@AfterSuite
	public void f2() {
		System.out.println("AfterSuite");
	}
	
	@BeforeTest
	public void f3() {
		System.out.println("BeforeTest");
	}
	
	@AfterTest
	public void f4() {
		System.out.println("AfterTest");
	}
	
	@BeforeClass
	public void f5() {
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public void f6() {
		System.out.println("AfterClass");
	}
	
	@BeforeMethod
	public void f7() {
		System.out.println("BeforeMethod");
	}
	
	@AfterMethod
	public void f8() {
		System.out.println("AfterMethod");
	}
	
	@Test(dependsOnMethods = "test2",alwaysRun = true,description = "test....")
	public void test1() {
		System.out.println("start test1");
//		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test2() {
		System.out.println("start test2");
//		Assert.assertEquals(false, true);
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}
}
