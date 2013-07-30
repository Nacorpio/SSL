package com.nacorpio.ssl.config;

public final class StructureUtil {

	public final static String getValueMarkup(String key, Object value) {
		return "<key=\"" + key + "\">" + value + "</key>";
	}
	
	public final static String getConstMarkup(String key, Object constValue){
		return "<const=\"" + key + "\">" + constValue + "</const>";
	}
	
}
