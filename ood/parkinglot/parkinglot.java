package parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

public class parkinglot {

	private static final int NUMBER_OF_SMALL_SLOTS = 10;
	private static final int NUMBER_OF_COMPACT_SLOTS = 10;
	private static final int NUMBER_OF_LARGE_SLOTS = 10;
	public Map<Long, slot> occupiedSlots;
	private List<slot> smallSlots;
	private List<slot> compactSlots;
	private List<slot> largeSlots;

	public parkinglot() {  
        smallSlots = new ArrayList<slot>(NUMBER_OF_SMALL_SLOTS);  
        compactSlots = new ArrayList<slot>(NUMBER_OF_COMPACT_SLOTS);  
        largeSlots = new ArrayList<slot>(NUMBER_OF_LARGE_SLOTS);  
        createSlots();  
        occupiedSlots = new HashMap<Long, slot>();  
    }	private void createSlots() {

		for (int i = 1; i <= NUMBER_OF_SMALL_SLOTS; i++) {
			smallSlots.add(new SmallSlot(i));
		}
		for (int i = 1; i <= NUMBER_OF_COMPACT_SLOTS; i++) {
			compactSlots.add(new CompactSlot(i));
		}
		for (int i = 1; i <= NUMBER_OF_LARGE_SLOTS; i++) {
			largeSlots.add(new LargeSlot(i));
		}

	}

	public long park(Vehicle vehicle) {

		slot slot;
		long uniqueToken = -1;

		if (vehicle instanceof Motorcycle) {
			if ((slot = getFirstEmptySlot(smallSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			} else if ((slot = getFirstEmptySlot(compactSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			} else if ((slot = getFirstEmptySlot(largeSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			}
		} else if (vehicle instanceof Car) {
			if ((slot = getFirstEmptySlot(compactSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			} else if ((slot = getFirstEmptySlot(largeSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			}
		} else {
			if ((slot = getFirstEmptySlot(largeSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			}
		}
		return uniqueToken;
	}

	public void unPark(long uniqueToken) {
		occupiedSlots.get(uniqueToken);
		occupiedSlots.remove(uniqueToken);
	}

	private slot getFirstEmptySlot(List<slot> slots) {
		Iterator<slot> slotIterator = slots.iterator();
		boolean isSlotFound = false;
		slot emptySlot = null;

		while (slotIterator.hasNext() && !isSlotFound) {
			emptySlot = slotIterator.next();
			if (!emptySlot.isOccupied()) {
				emptySlot.park();
				isSlotFound = true;
			}
		}
		return emptySlot;
	}

	private long parkHelper(slot slot, Vehicle vehicle) {
		long uniqueToken = vehicle.hashCode() * 43;
		occupiedSlots.put(uniqueToken, slot);
		return uniqueToken;
	}
}


public abstract class slot {
	private boolean isOccupied;
	private int slotNumber;

	public slot(int slotNumber) {
		isOccupied = false;
		this.slotNumber = slotNumber;
	}

	boolean isOccupied() {
		return isOccupied;
	}

	int getSlotNumber() {
		return slotNumber;
	}

	void park() {
		isOccupied = true;
	}

	void unPark() {
		isOccupied = false;
	}

	public boolean equals(Object o) {
		return (((slot) o).slotNumber == this.slotNumber);
	}

	public int hashCode() {
		int hash = 5;
		hash = 53 * hash + this.slotNumber;
		return hash;
	}
}

class SmallSlot extends slot {

	SmallSlot(int slotNumber) {
		super(slotNumber);
	}
}

class LargeSlot extends slot {

	LargeSlot(int slotNumber) {
		super(slotNumber);
	}
}

class CompactSlot extends slot {

	CompactSlot(int slotNumber) {
		super(slotNumber);
	}
}

public abstract class Vehicle {

}

class Bus extends Vehicle {

}
class Car extends Vehicle {

}
class Motorcycle extends Vehicle {

}