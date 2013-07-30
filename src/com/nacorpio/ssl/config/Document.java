package com.nacorpio.ssl.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.nacorpio.ssl.utilities.StructureUtil;

public class Document {
	
	private String fileName;
	
	private List<Value> values = new ArrayList<Value>();

	public Document(String fileName) {
		if (fileName != "" && fileName != null) {
			this.fileName = fileName;
		}
	}
	
	/**
	 * Returns the file name of the file to write to when saving.
	 * @return the file name of the document.
	 */
	public String getFileName() {
		return this.fileName;
	}
	
	/**
	 * Returns all the values within the document.
	 * @return all the values of the document.
	 */
	public final List<Value> getValues() {
		return this.values;
	}
	
	public final void addValue(String key, Object value) throws IOException {
		if (!getValueExists(key)) {
			values.add(new Value(key, value));
			save();
		} else {
			System.out.println("[SSL-Error]: A value with the key \"" + key + "\" already exists.");
		}
	}

	public final void removeValue(String key) throws IOException {
		if (getValueExists(key)) {
			int index = 0;
			int finalIndex = 0;
			for (Value value: values) {
				index++;
				if (value.getKey() == key) {
					finalIndex = index - 1;
				}
			}
			values.remove(finalIndex);
			save();
		} else {
			System.out.println("[SSL-Error]: There's no value with the key \"" + key + "\".");
		}
	}
	
	public final boolean getValueExists(String key) throws IOException{
		return getValue(key) != null;
	}
	
	public final void editValue(String key, Object newValue) throws IOException {
		if (getValueExists(key)) {
			for (Value value: values) {
				if (value.getKey() == key) {
					value.setValue(newValue);
				}
			}
			save();
		} else {
			System.out.println("[SSL-Error]: There's no value with the key \"" + key + "\".");
		}
	}
	
	public final void callMethod(String key) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (getValue(key).getValue() instanceof Method) {
			Method met = (Method) getValue(key).getValue();
			met.invoke(null);
		}
	}
	
	public final Value getValue(String key) throws IOException {
		Value value = null;
		for (Value v: values) {
			if (v.getKey() == key) {
				value = v;
			}
		}
		return value;
	}
	
	public final void saveAs(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		for (Value value: values) {
			if (value.getValue() instanceof String || value.getValue() instanceof Integer || value.getValue() instanceof Long || value.getValue() instanceof Double) {
				writer.println(StructureUtil.getValueMarkup(value.getKey(), value.getValue()));
			} else if (value.getValue() instanceof ArrayList<?>) {
				writer.println(StructureUtil.getArrayMarkup(value.getKey(), (ArrayList<?>) value.getValue()));
			} else if (value.getValue() instanceof List<?>) {
				writer.println(StructureUtil.getListMarkup(value.getKey(), (List<?>) value.getValue()));
			} else if (value.getValue() instanceof Method) {
				writer.println(StructureUtil.getMethodMarkup(value.getKey(), (Method) value.getValue()));
			}
		}
		writer.close();
	}
	
	public final void save() throws FileNotFoundException, UnsupportedEncodingException {
		saveAs(this.fileName);
	}
	
	public final void open(String fileName) throws IOException {
		this.fileName = fileName;
		reload();
	}
	
	private final void reload() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(this.fileName));
		String line;
		this.values.clear();
		while ((line = br.readLine()) != null) {
		   String key = line.split("\"")[1];
		   Object val = line.split("\">")[1].split("</value>")[0];
		   values.add(new Value(key, val));
		}
		br.close();
	}
	
}
