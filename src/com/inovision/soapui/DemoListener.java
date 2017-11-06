package com.inovision.soapui;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.support.TestRunListenerAdapter;
import com.eviware.soapui.model.testsuite.TestCaseRunContext;
import com.eviware.soapui.model.testsuite.TestCaseRunner;

public class DemoListener extends TestRunListenerAdapter {

	private long starttime;
	
	@Override
	public void beforeRun(TestCaseRunner testRunner, TestCaseRunContext runContext) {
		super.beforeRun(testRunner, runContext);
		starttime = System.currentTimeMillis();
	}
	
	@Override
	public void afterRun(TestCaseRunner testRunner, TestCaseRunContext runContext) {
		super.afterRun(testRunner, runContext);
		long endtime = System.currentTimeMillis();
		SoapUI.log(String.format("Testcase [%s] took [%d] milliseconds", testRunner.getTestCase().getName(), endtime - starttime));
	}
}
