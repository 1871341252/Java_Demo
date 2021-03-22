package testng_demo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo3 {
	@Test
	@Parameters({"firstname","lastname"})
	public void test5(String args1,String args2) {
		System.out.println(args1+args2);
	}

}
