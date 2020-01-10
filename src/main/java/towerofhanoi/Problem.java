package towerofhanoi;

import java.math.BigDecimal;

public class Problem {

	/**
	 * This method is used to get expected value
	 * 
	 * @return BigDecimal value
	 */
	public static BigDecimal problrmValue() {

		double move = Math.pow(10, 9);
		double totalExpValue = 0, prevDisk = 0, currDisk = 1, k = 10, a = 3, b = 6, c = 9;

		for (int n = 1; n < (10000 + 1); n++) {

			double expectedValue = (2 * currDisk * (c - a) * (k - 1) - (2 * k - b - c) * (c - b)) % move;
			totalExpValue = (totalExpValue + expectedValue) % move;
			prevDisk = currDisk;
			currDisk = (currDisk + 2 * prevDisk + 1) % move;
			k = (k * 10) % move;
			a = (a * 3) % move;
			b = (b * 6) % move;
			c = (c * 9) % move;
		}
		return BigDecimal.valueOf(totalExpValue);
	}
}
