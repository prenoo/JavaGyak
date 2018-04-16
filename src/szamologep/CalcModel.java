package szamologep;

public class CalcModel {
	private static final int INIT_VALUE = 1;
	private int value;

	public CalcModel() {
		value = INIT_VALUE;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int x) {
		value = x;
	}

	public void reset() {
		value = INIT_VALUE;
	}

	public void operation(int a, int b) {
		value = a * b;
	}
}