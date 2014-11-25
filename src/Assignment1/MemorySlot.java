package Assignment1;

public class MemorySlot {
	
	private char value;
	private int slot;
	private boolean active = true;
	
	public MemorySlot(char c, int slot) {
		// TODO Auto-generated constructor stub
		value = c;
	}

	public char getValue() {
		return value;
	}
	
	public int getSlot() {
		return slot;
	}
	
	public void setActive(boolean a) {
		active = a;
	}
	
	public boolean isActive() {
		return active;
	}

}
