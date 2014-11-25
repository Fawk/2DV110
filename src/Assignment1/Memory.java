package Assignment1;

import java.util.Random;

public class Memory {
	
	private char[] values = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
	private MemorySlot[] slots;
	private MemorySlot turned;
	private int tries = 0;

	public Memory(int pairs) {
		if(pairs < 1 || pairs > 10) {
			throw new IllegalArgumentException();
		}
		
		slots = new MemorySlot[pairs*2];
		for(int i = 0; i < pairs * 2; i++) {
			slots[i] = new MemorySlot(generateValue(pairs), i);
		}
	}

	private char generateValue(int pairs) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int n = rand.nextInt(pairs);
		while(isTakenTwice(values[n])) {
			n = rand.nextInt(pairs);
		}
		return values[n];
	}

	private boolean isTakenTwice(char c) {
		// TODO Auto-generated method stub
		int r = 0;
		for(int i = 0; i < slots.length; i++) {
			if(slots[i] == null) break;
			if(slots[i].getValue() == c)
				r++;
		}
		return r == 2;
	}

	public int getPairs() {
		return slots.length / 2;
	}

	public int getSlots() {
		return slots.length;
	}

	public void SetFakeOrder(char[] c) {
		// TODO Auto-generated method stub
		slots = new MemorySlot[c.length*2];
		for(int i = 0; i < slots.length; i++) {
			if(i >= (slots.length / 2)) {
				slots[i] = new MemorySlot(c[i - (slots.length/2)], i);
			} else {
				slots[i] = new MemorySlot(c[i], i);
			}
		}
	}

	public boolean sameSlotValue(MemorySlot s1, MemorySlot s2) {
		// TODO Auto-generated method stub
		return (s1.getValue() == s2.getValue());
	}

	public MemorySlot getMemorySlot(int i) {
		return slots[i];
	}

	public boolean turnSlot(int slot) {
		if(turned == null) {
			turned = getMemorySlot(slot);
			return true;
		}
		
		if(turned.getSlot() == slot)
			return false;
		
		if(!getMemorySlot(slot).isActive())
			return false;
		
		if(turned.getValue() == getMemorySlot(slot).getValue()) {
			
			slots[slot].setActive(false);
			slots[turned.getSlot()].setActive(false);
			
			turned = null;
			tries++;
			return true;
		} else {
			turned = null;
			tries++;
			return true;
		}
	}

	public int TestGame() {
		
		while(!Won()) {
			Random rand = new Random();
			turnSlot(rand.nextInt(getSlots()));
		}
		
		return tries;
	}

	private boolean Won() {
		int r = 0;
		for(int i = 0; i < getSlots(); i++) {
			if(!getMemorySlot(i).isActive())
				r++;
		}
		return r == getSlots();
	}
}
