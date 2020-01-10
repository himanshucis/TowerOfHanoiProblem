/**
 * 
 */
package towerofhanoi.test;

import org.junit.Test;

import junit.framework.TestCase;
import towerofhanoi.TowerOfHanoi;

/**
 * @author cis
 *
 */
public class TowerOfHanoiTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	TowerOfHanoi towerOfHanoi = new TowerOfHanoi();

	@Test
	public void testTowerOfHanoi1() {
		System.out.println("test 1  ==>>" + towerOfHanoi.startMoveDiskProcess(1));
	}

	@Test
	public void testTowerOfHanoi2() {
		System.out.println("test 2  ==>>" + towerOfHanoi.startMoveDiskProcess(2));
	}

	@Test
	public void testTowerOfHanoi3() {
		System.out.println("test 3  ==>>" + towerOfHanoi.startMoveDiskProcess(3));
	}

	@Test
	public void testTowerOfHanoi4() {
		System.out.println("test 4  ==>>" + towerOfHanoi.startMoveDiskProcess(4));
	}

}
