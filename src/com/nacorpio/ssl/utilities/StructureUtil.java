package com.nacorpio.ssl.utilities;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class StructureUtil {

	public final static String getValueMarkup(String key, Object value) {
		return "<key=\"" + key + "\">" + value + "</key>";
	}
	
	public final static String getArrayMarkup(String key, ArrayList<?> arrayList) {
		String markup = "<key=\"" + key + "\">{";
		for (Object obj: arrayList) {
			markup += "[" + obj.toString() + "]";
		}
		markup += "}</key>";
		return markup;
	}
	
	public final static String getMethodMarkup(String key, Method met) {
		return "<met=\"" + key + "\">@" + met.getName() + "</met>";
	}
	
	public final static String getListMarkup(String key, List<?> list) {
		String markup = "<key=\"" + key + "\">{";
		for (Object obj: list) {
			markup += "[" + obj.toString() + "]";
		}
		markup += "}</key>";
		return markup;
	}
	
	public final static String getConstMarkup(String key, Object constValue){
		return "<const=\"" + key + "\">" + constValue + "</const>";
	}
	
}
