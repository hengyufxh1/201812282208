package com.itstar.commons.test;

public class Normal {

	public static void main(String[] args) {
		double zhengtai0_1;
		java.util.Random r = new java.util.Random();

		for (int i = 0; i < 20; i++) {
			zhengtai0_1 = r.nextGaussian();
			System.out.println(zhengtai0_1);
		}

	}

	public Normal() {
	}

	public double nextDouble() {
		return (((long) (next(26)) << 27) + next(27)) / (double) (1L << 53);
	}

	private long next(int i) {
		// TODO Auto-generated method stub
		return i;
	}

	private double nextNextGaussian;

	private boolean haveNextNextGaussian = false;

	synchronized public double nextGaussian() {

		// See Knuth, ACP, Section 3.4.1 Algorithm C.

		if (haveNextNextGaussian) {
			haveNextNextGaussian = false;
			return nextNextGaussian;
		} else {
			double v1, v2, s;
			do {
				v1 = 2 * nextDouble() - 1; // between -1 and 1
				v2 = 2 * nextDouble() - 1; // between -1 and 1
				s = v1 * v1 + v2 * v2;
			} while (s >= 1 || s == 0);
			double multiplier = StrictMath.sqrt(-2 * StrictMath.log(s) / s);
			nextNextGaussian = v2 * multiplier;
			haveNextNextGaussian = true;
			return v1 * multiplier;

		}
	}
}