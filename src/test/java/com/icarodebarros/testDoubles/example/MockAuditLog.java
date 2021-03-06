package com.icarodebarros.testDoubles.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockAuditLog implements AuditLog {
	private String expectedLogType;
	private String expectedSubtype;
	private String expectedData;
	private boolean logCalled;
	private boolean enableAssertions;
	
	@Override
	public void log(String logType, String subtype, String data) {
		if (enableAssertions) {
			assertEquals(expectedLogType,logType);
			assertEquals(expectedSubtype,subtype);
			assertEquals(expectedData,data);
			logCalled = true;
		}
	}

	public void verify() {
		assertTrue(logCalled);
	}

	public void expect(String logType, String subtype, String data) {
		expectedLogType = logType;
		expectedSubtype = subtype;
		expectedData = data;
	}

	public void enable() {
		enableAssertions = true;
	}

}
