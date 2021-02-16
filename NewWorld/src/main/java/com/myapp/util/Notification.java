package com.myapp.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Notification {
	private final Map<String, Boolean> map = new HashMap<>();
	
	public void put(String key, Boolean value) {
		map.put(key, value);
	}
	
	public Boolean get(String key) {
		return map.get(key);
	}
	
	public int size() {
		return map.size();
	}
	
	public void clear() {
		map.clear();
	}
	
	public boolean isEmpty() {
		return map.isEmpty();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		if ( isEmpty() ) {
			sb.append("empty");
		} else {
			sb.append("Error(");
			Iterator<Entry<String, Boolean>> iter = map.entrySet().iterator();
			
			while (iter.hasNext()) {
				Entry<String, Boolean> entry = iter.next();
				sb.append(entry.getKey() + "=" + entry.getValue() + ",");
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			
			sb.append(")");
		}
		
		return sb.toString();
	}
}
