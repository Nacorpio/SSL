package com.nacorpio.ssl.utilities;

import java.util.Random;

/**
 * The Zeta pattern allows you to generate a combination for your own likings.<br>
 * Zeta provide you with flags that can be used within the pattern.
 */
public class ZetaPattern {

	// My name is {-name} - Generates a random name.
	// My name is {-d} - Generates a random digit.
	// My name is {-up} - Generates a random upper-case character.
	// My name is {-low} - Generates a random lower-case character.
	
	// My name is {-low:10,} - Generates 10 random lower-case characters.
	
	public static final String alpha_lower = "abcdefghijklmnopqrstuvwxyz";
	public static final String alpha_upper = alpha_lower.toUpperCase();
	public static final String symbolic_one = "!\"#€%&/()=";
	public static final String symbolic_two = "©@£$∞§|[]≈±";
	
	private String pattern;
	
	public ZetaPattern(String pattern) {
		this.pattern = pattern;
	}
	
	public String compile(){
		
		String ret = "";
		
		Random rnd = new Random(System.nanoTime());
		
		int cStartPoint = 0;
		int cEndPoint = 0;
		int cIndex = 0;
		
		for (int i = 0; i < pattern.length(); i++) {
			String cchar = String.valueOf(pattern.toCharArray()[i]);
			cIndex++;
			if (cchar.equals("{")) {
				// Starts the flag.
				cStartPoint = cIndex - 1;
				continue;
			} else if (cchar.equalsIgnoreCase("}")) {
				// Ends the flag.
				cEndPoint = cIndex - 1;
			}
		}
		
		String packet = pattern.substring(cStartPoint, cEndPoint);
		String[] flags = packet.split(",");
		
		for (String flag: flags) {
			int times = 1;
			if (flag.split(":").length > 0) {
				times = Integer.parseInt(flag.split(":")[1]);
			}
			for (int i = 0; i < times; i++) {
				if (flag.equals("-d")) {
					ret += String.valueOf(rnd.nextInt(9));
				} else if (flag.equals("-low")) {
					ret += String.valueOf(alpha_lower.toCharArray()[rnd.nextInt(alpha_lower.toCharArray().length)]);
				} else if (flag.equals("-up")) {
					ret += String.valueOf(alpha_upper.toCharArray()[rnd.nextInt(alpha_upper.toCharArray().length)]);
				}
			}		
		}
		
		return ret;
	}
	
}
