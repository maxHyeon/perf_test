package com.sds.perf.ch03.objectpool;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;

public class ObjectStorage {
	public Hashtable hTables = null;

	public ObjectStorage() {
		hTables = new Hashtable();
	}

	public Enumeration elements() {
		return hTables.elements();
	}

	public void put(String key, Object obj) {
		if (hTables.containsKey(key)) {
			Vector list = (Vector) hTables.get(key);
			list.addElement(obj);
		} else {
			// 만약에 안에 없으면 하나 만들어서 넣어준다.
			Vector list = new Vector();
			list.addElement(obj);
			hTables.put(key, list);
		}
	}

	public Object get(String key) {
		if (hTables.containsKey(key)) {
			Vector list = (Vector) hTables.get(key);
			if (list != null) {
				Object obj = null;
				try {
					obj = list.firstElement();
					list.removeElement(obj);
				} catch (Exception e) {
					obj = null;
				}

				return obj;
			} else
				return null;
		} else
			return null;
	}
}
