package com.nacorpio.ssl.config;

import java.io.IOException;
import java.util.ArrayList;

public final class TestConsole {

	public static void main(String[] args) throws IOException {
		Document doc = new Document("/Users/gustavjeppsson/Desktop/text.txt");
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hey there");
		list.add("See you");
		doc.addValue("list", list);
		// doc.removeValue("name");
	}

}
