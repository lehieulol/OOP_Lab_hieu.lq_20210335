package Lab01;

import java.util.Arrays;

public class OOP_lab_6_5 {
	protected static Double arr[] = {1789.0, 2035.0, 1899.0, 1456.0, 2013.0};
	public OOP_lab_6_5() {
		//pass
	}

	public static void main(String[] args) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		Double sum = 0.0;
		for (Double i : arr) {
			sum += i;
		}
		System.out.println(String.format("Sum: %.2f\nAverage: %.2f", sum, sum/arr.length));
	}

}
