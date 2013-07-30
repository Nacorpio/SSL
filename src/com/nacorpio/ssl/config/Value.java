package com.nacorpio.ssl.config;

public class Value {

	private String key;
	private Object value;
	
	public Value(String key, Object value){
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Returns the key/identifier for the {@link Value}.<br>
	 * This is used for finding the value later on.
	 * @return the key for the value.
	 */
	public String getKey(){
		return key;
	}
	
	/**
	 * Returns the value for the {@link Value}.<br>
	 * This can be set to whatever you like.<br>
	 * All classes can be read and be parsed.
	 * @return the value for the value.
	 */
	public Object getValue(){
		return value;
	}
	
	public final void setValue(Object newValue) {
		this.value = newValue;
	}
	
}
