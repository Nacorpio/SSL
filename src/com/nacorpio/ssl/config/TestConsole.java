package com.nacorpio.ssl.config;

import java.io.IOException;

public final class TestConsole {

	public static void main(String[] args) throws IOException {
		Document doc = new Document("/Users/gustavjeppsson/Desktop/text.txt");
		doc.addValue("name", "Nacorpio");
		// doc.removeValue("name");
	}

}
