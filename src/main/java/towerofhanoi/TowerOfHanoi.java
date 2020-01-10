package towerofhanoi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TowerOfHanoi {

	// list of map key value pair
	List<Map<Integer, Integer>> diskMoves;

	// TowerOfHanoi constructor Initialize List
	public TowerOfHanoi() {
		diskMoves = new ArrayList<Map<Integer, Integer>>();
	}

	/**
	 * startMoveDiskProcess by required values for move disks 
	 * 
	 * @param n
	 * @return
	 */
	public Map<Map<Integer, Integer>, Integer> startMoveDiskProcess(int n) {
		int a = 0, b = 1, c = 2;
		moveTower(n, a, c, b);
		return moveStatistics(a, b, c);
	}

	/**
	 * Recursive call for Bob movement to move disk fromPeg to toPeg
	 * 
	 * @param height
	 * @param fromDisk
	 * @param toDisk
	 * @param withDisk
	 */
	public void moveTower(int height, int fromDisk, int toDisk, int withDisk) {

		if (height >= 1) {
			moveTower(height - 1, fromDisk, withDisk, toDisk);
			moveDisk(fromDisk, toDisk);
			moveTower(height - 1, withDisk, toDisk, fromDisk);
		}
	}

	/**
	 * Written logic to move disk from one rod to another
	 * 
	 * @param fromTower
	 * @param toTower
	 */
	public void moveDisk(int fromTower, int toTower) {
		Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
		tempMap.put(fromTower, toTower);
		diskMoves.add(tempMap);
	}

	/**
	 * This method is used to hold statistics of diskMoves
	 * 
	 * @param a rod a value
	 * @param b rod b value
	 * @param c rod c value
	 * @return Map<Map<Integer, Integer>, Integer>
	 */
	public Map<Map<Integer, Integer>, Integer> moveStatistics(int a, int b, int c) {

		// created position map of map with integer value to hold pair with integer
		// count
		Map<Map<Integer, Integer>, Integer> diskPosition = new HashMap<Map<Integer, Integer>, Integer>();
		int movementCount = diskMoves.size();
		for (int i = 0; i < movementCount - 1; i++) {

			// getting map paired of number from movement list
			Map<Integer, Integer> tempNMap = diskMoves.get(i);

			int currentFromdisk = 0, currentToDisk = 0, nextFromDisk = 0;
			
			Map<Integer, Integer> tempNth1Map = diskMoves.get(i + 1);

			// getting key value and assign to variable like currFromPeg, curreTopeg etc.
			for (Map.Entry<Integer, Integer> entry : tempNMap.entrySet()) {
				currentFromdisk = entry.getKey();
				currentToDisk = entry.getValue();
			}

			for (Map.Entry<Integer, Integer> entry : tempNth1Map.entrySet()) {
				nextFromDisk = entry.getKey();
			}

			// Create new map for currFromToMap and nextFromPeg
			Map<Integer, Integer> currentFromTo = new HashMap<Integer, Integer>();
			Map<Integer, Integer> nextFromTo = new HashMap<Integer, Integer>();

			currentFromTo.put(currentFromdisk, currentToDisk);
			nextFromTo.put(currentToDisk, nextFromDisk);

			List<Map<Integer, Integer>> tempFromToPegList = new ArrayList<Map<Integer, Integer>>();
			tempFromToPegList.add(currentFromTo);
			tempFromToPegList.add(nextFromTo);

			tempFromToPegList.forEach(currMovement -> {
				if (!diskPosition.containsKey(currMovement)) {
					diskPosition.put(currMovement, 0);
				}
				diskPosition.put(currMovement, diskPosition.get(currMovement) + 1);

			});
		}

		Map<Integer, Integer> currMovement = diskMoves.get(movementCount - 1);
		if (!diskPosition.containsKey(currMovement)) {
			diskPosition.put(currMovement, 0);
		}
		diskPosition.put(currMovement, diskPosition.get(currMovement) + 1);
		return mergeStatistics(diskPosition, a, b, c);
	}

	/**
	 * This method is used to merge statistics by checking key value paired in
	 * current state
	 * 
	 * @param state
	 * @param a     rod a value
	 * @param b     rod b value
	 * @param c     rod c value
	 * @return Map<Map<Integer, Integer>, Integer>
	 */
	public Map<Map<Integer, Integer>, Integer> mergeStatistics(Map<Map<Integer, Integer>, Integer> state, int rodA,
			int rodB, int rodC) {

		Map<Integer, Integer> rodAb = new HashMap<Integer, Integer>();
		Map<Integer, Integer> rodBc = new HashMap<Integer, Integer>();
		Map<Integer, Integer> rodAc = new HashMap<Integer, Integer>();
		rodAb.put(rodA, rodB);
		rodBc.put(rodB, rodC);
		rodAc.put(rodA, rodC);
		if (state.containsKey(rodAb) && state.containsKey(rodBc) && state.get(rodAb) == state.get(rodBc)) {
			if (!state.containsKey(rodAc)) {
				state.put(rodAc, 0);
			}
			state.put(rodAc, state.get(rodAc) + state.get(rodAb));
			state.remove(rodAb);
			state.remove(rodBc);
		}

		Map<Integer, Integer> rodCb = new HashMap<Integer, Integer>();
		Map<Integer, Integer> rodBa = new HashMap<Integer, Integer>();
		Map<Integer, Integer> rodCa = new HashMap<Integer, Integer>();
		rodCb.put(rodC, rodB);
		rodBa.put(rodB, rodA);
		rodCa.put(rodC, rodA);
		if (state.containsKey(rodCb) && state.containsKey(rodBa) && state.get(rodCb) == state.get(rodBa)) {
			if (!state.containsKey(rodCa)) {
				state.put(rodCa, 0);
			}
			state.put(rodCa, state.get(rodCa) + state.get(rodCb));
			state.remove(rodCb);
			state.remove(rodBa);
		}
		return state;
	}
}
