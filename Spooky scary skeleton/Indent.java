package skeleton;

public class Indent {
	static int in = 0;

	public static void inc() {
		in++;
	}

	public static void dec() {
		in--;
	}

	public static void print(String msg) {
		for (int i = 0; i < in; i++) {
			System.out.print("\t");
		}
		System.out.println(msg);
	}

	public static void printr(String msg) {
		for (int i = 0; i < in; i++) {
			System.out.print("\t");
		}
		System.out.print(msg);
	}


}
