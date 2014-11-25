package Assignment1;

import java.util.Random;

public class Memory {
	
	private char[] values = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
	private MemorySlot[] slots;

	public Memory(int pairs) {
		if(pairs < 1 || pairs > 10) {
			throw new IllegalArgumentException();
		}
		
		slots = new MemorySlot[pairs*2];
		for(int i = 0; i < pairs * 2; i++) {
			slots[i] = new MemorySlot(generateValue(pairs));
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
				slots[i] = new MemorySlot(c[i - (slots.length/2)]);
			} else {
				slots[i] = new MemorySlot(c[i]);
			}
		}
	}

	public boolean sameSlotValue(MemorySlot s1, MemorySlot s2) {
		// TODO Auto-generated method stub
		return (s1.getValue() == s2.getValue());
	}

	public MemorySlot getSlot(int i) {
		return slots[i];
	}
}
