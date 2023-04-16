package Lab01;

public class OOP_lab_6_6 {
	protected static float[][] a = {{1,2},{3,4}}, b = {{4,1},{3,2}};
	public OOP_lab_6_6() {
		// pass
	}
	
	public static float[][] add(float[][] a, float[][] b) {
		float[][] ret = {{}};
		if (a.length != b.length) {
			return ret;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i].length != b[i].length) {
				return ret;
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] += b[i][j];
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		a = add(a, b);
		for (float[] i : a) {
			for (float j : i) {
				System.out.print(String.format("%.2f ", j));
			}
			System.out.println();
		}
	}

}
