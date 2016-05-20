import java.util.Arrays;

import init.main;


public class Array {
	public static void main(String[] args) {
		Object[] a = new Object[] {"a","b","c"};
		Object[] b = Arrays.copyOfRange(a, 0, 1);
		for (Object object : b) {
			System.err.println(object);
		}
	}

}
