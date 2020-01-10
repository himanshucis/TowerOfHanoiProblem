package towerofhanoi;

/**
 * Hello world!
 *
 */
public class MainMethod {

	// instance of class TowerOfHanoi for method execution
	static TowerOfHanoi towerOfHanoi = new TowerOfHanoi();

	public static void main(String[] args) {
		for (int n = 1; n < (10 + 1); n++) {
			System.out.println("disk "+n +" :- "+ towerOfHanoi.startMoveDiskProcess(n));
		}
		System.out.println("Total Movement ==>> "+Problem.problrmValue());
	}
}
