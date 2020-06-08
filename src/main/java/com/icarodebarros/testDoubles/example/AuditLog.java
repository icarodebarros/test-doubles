package com.icarodebarros.testDoubles.example;

public interface AuditLog {
	void log(String logType,String subtype,String data);
}