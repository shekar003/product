package com.io.util;

import java.util.HashMap;
import java.util.Map;

public class One {

	public static void main(String[] args) {

		/*
		 * String s = "Yah oogo oGleI nd iA";
		 * 
		 * String s2 =
		 * "  9te!!3r M1   ina#t o+K0301c o@  m  purT   ER4)_iNo wh%L6 aHe    r ";
		 * 
		 * String s1 = s2.replace(" ", "O"); System.out.println(s1);
		 * 
		 * String s3[] = s2.split("");
		 * 
		 * System.out.println(s3.length);
		 * 
		 * for(int i =0;i<s3.length;i++) {System.out.println(s3[i]);
		 * 
		 * if(s3[i].matches("m")) {
		 * 
		 * System.out.println(s1.concat("  L")); }
		 * 
		 * }
		 * 
		 * String s4 = s2.toLowerCase();
		 * 
		 * System.out.println(s4);
		 * 
		 * String s6 = s4.replaceAll("\\s+", " ");
		 * 
		 * 
		 * System.out.println(s6);
		 * 
		 * String s5 = s4.replaceAll("[^a]", ""); System.out.println(s5);
		 * 
		 * String s7=s6.replace(" ","");
		 * 
		 * System.out.println(s7);
		 * 
		 * 
		 * 
		 * Map<Integer, String> map = new HashMap<Integer, String>();
		 * 
		 * map.put(1, "one"); map.put(2, "one");
		 * 
		 * Map<Integer, String> map1 = new HashMap<Integer, String>();
		 * 
		 * map1.put(3, "one"); map1.put(4, "two");
		 */

		Map<Integer, String> map2 = new HashMap<Integer, String>();

		map2.put(5, "five");
		map2.put(6, "six");
		map2.put(8, "eight");
		map2.put(5, "second five");
		map2.put(9, "nine");
		map2.put(107, "ten");
		map2.put(11, "eleven");
		map2.put(7, "seven");
		map2.put(12, "twelve");
		map2.put(13, "thirteen");
		map2.put(10, "second ten");
		map2.putIfAbsent(5, "third five");

		map2.putIfAbsent(14, "fourteen");
		for (int i = 0; i <= 20; i++) {
			if (!map2.containsKey(i)) {

				map2.put(i, "value_" + i);

			}
		}

		/*
		 * 
		 * Map<Integer, Map<Integer, String>> map4 = new HashMap<Integer, Map<Integer,
		 * String>>();
		 * 
		 * map4.put(10, map); map4.put(11, map1); map4.put(12, map2);
		 * 
		 * System.out.println(s.compareTo("soma"));
		 * 
		 * System.out.println(s.contains("^[Y].*"));
		 * 
		 * //Map<Character, Integer> smap = new HashMap<Character,Integer>();
		 * 
		 * 
		 * 
		 * 
		 * for (char c : s.toLowerCase().toCharArray()) {
		 * 
		 * if (smap.containsKey(c)) { smap.put(c, smap.get(c) + 1); } else {
		 * 
		 * smap.put(c, 1);
		 * 
		 * } }
		 * 
		 * for (char c : smap.keySet()) {
		 * 
		 * if (smap.get(c) > 1) System.out.println(c + " : " + smap.get(c) + " Times");
		 * 
		 * }
		 * 
		 * Map<Character, Integer> ymap = new HashMap();
		 * 
		 * for (char c : s2.toLowerCase().toCharArray()) {
		 * 
		 * ymap.put(c, ymap.getOrDefault(c, 0) + 1);
		 * 
		 * }
		 * 
		 * ymap.forEach((k, v) -> {
		 * 
		 * if (v > 1) {
		 * 
		 * System.out.println(k + " : " + v + " Timess");
		 * 
		 * }
		 * 
		 * });
		 * 
		 * 
		 * System.out.println(s2.matches(".*\\d.*"));
		 * 
		 * System.out.println(s2.replace("\\D", " "));
		 * 
		 * System.out.println(s2.matches(".*r$"));
		 * 
		 * String lowercase = s2.toLowerCase();
		 * 
		 * for (int i = 0; i < lowercase.toLowerCase().length(); i++) {
		 * 
		 * for (int k = i + 1; k < lowercase.toLowerCase().length(); k++) {
		 * 
		 * if (lowercase.charAt(i) == lowercase.charAt(k)) {
		 * 
		 * System.out.println(lowercase.charAt(i));
		 * 
		 * break; }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * 
		 * String alphabets = s2.replaceAll("[^a-zA-Z]", "");
		 * System.out.println(alphabets);
		 * 
		 * 
		 * String result = s2.replaceAll("[^0-9]", ""); System.out.println(result);
		 * 
		 * 
		 * System.out.println(s2.split("\\d"));
		 */

		/*
		 * String s = "dfdfaereregfddvfdbrwwtqfa";
		 * System.out.println(s.matches("^[aeiou].*"));
		 * 
		 * 
		 * Integer midlength = s.length()/2;
		 * 
		 * System.out.println(s.substring(0, midlength).toLowerCase());
		 * 
		 * System.out.println(s.substring(midlength).toUpperCase());
		 * 
		 */

	}

}
