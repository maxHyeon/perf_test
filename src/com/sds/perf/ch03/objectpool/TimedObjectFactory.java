package com.sds.perf.ch03.objectpool;

public class TimedObjectFactory {
	public static TimedObject getObject(String key) {
		if (key.equals("Test"))
			return new TestObject01();
		else
			return null;
	}
}
