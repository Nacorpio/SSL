package com.nacorpio.ssl.config;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public final class TestConsole {

	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException {
		Document doc = new Document("/Users/gustavjeppsson/Desktop/text.txt");
		doc.addValue("something", TestConsole.class.getMethod("doSomething"));
		doc.callMethod("something");
	}

	public void doSomething() {System.out.println("Hello there!");}
	
}
