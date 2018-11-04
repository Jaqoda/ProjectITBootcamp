package automationFramework;

import tests.TestSuite;

public class Apache_POI_TC {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "/Users/jagoda/Downloads/chromedriver");
		
		System.out.println("RUNNING ALL TESTS");
		int i = 0;
		
		// here we'll call all scenarios from test suite
		TestSuite testSuite = new TestSuite();
		
		// call login action
		testSuite.successLogin();
		i++;
		
		// add bussines
		testSuite.successAddNewBussines();
		i++;
		
		// add client
		testSuite.successAddNewClient();
		i++;
		
		System.out.println("TESTS FINISHED. COMPLETED: " + i + " TESTS. CHECK RESULTS IN EXCEL");
	}

}

