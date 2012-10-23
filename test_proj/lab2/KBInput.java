package lab2;

import java.io.*;
import java.util.*;

////////* Class for basic type keyboard input automation *////////
public class KBInput {

	////////////////* input from keyboard methods *////////////////
	////////////////* HUGE exception handling modifications HERE!!! *////////////////

	public static int readInt() throws IOException {
		/* String str = "";
		BufferedReader value = new BufferedReader(new InputStreamReader(System.in));
		str = value.readLine(); */

		String str = KBInput.readStr();
		Integer n = Integer.decode(str);
		int result = n.intValue();
		return result;
	}

	public static float readFloat() throws IOException {
		/* String str = "";
		BufferedReader value = new BufferedReader(new InputStreamReader(System.in));
		str = value.readLine(); */

		String str = KBInput.readStr();
		float result = (Float.valueOf(str)).floatValue();
		return result;
	}

	public static double readDouble() throws IOException {
		String str = KBInput.readStr();
		double result = (Double.valueOf(str)).doubleValue();
		return result;
	}

	public static String readStr() {
		String str = "";
		boolean x;

		do {
			x = false;
			try {
				BufferedReader value = new BufferedReader(new InputStreamReader(System.in));
				str = value.readLine();
			}
			catch (IOException e) {
				x = true;
				System.out.println("Could not read from input! Try again.");
			}
		}
		while (x);
		return str;
	}
}
		
















