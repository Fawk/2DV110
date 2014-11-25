package Assignment1;

import org.junit.*;

import Assignment1.Memory;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MemoryTests {
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructor() throws IllegalArgumentException {
		new Memory(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTooLargeMemorySize() throws IllegalArgumentException {
		new Memory(12);
	}

	@Test
	public void testMemorySize() {
		Memory m = new Memory(5);
		
		assertEquals(5, m.getPairs());
		assertEquals(10, m.getSlots());
	}
	
	@Test
	public void testMemorySlot() {
		Memory m = new Memory(5);
		
		char[] c = { 'A', 'B', 'C', 'D', 'E' };
		
		m.SetFakeOrder(c);
		
		for(int i = 0; i < 10; i++) {
			MemorySlot mockedSlot = mock(MemorySlot.class);
			if(i >= c.length) {
				when(mockedSlot.getValue()).thenReturn(c[i - (c.length)]);
			} else {
				when(mockedSlot.getValue()).thenReturn(c[i]);
			}
			MemorySlot realSlot = m.getMemorySlot(i);
			boolean result = m.sameSlotValue(mockedSlot, realSlot);
			assertTrue(result);
		}
	}
	
	@Test
	public void testPickedSlot() {
		Memory m = new Memory(5);
		boolean r1 = turnSlot(m, 0);
		assertTrue(r1);
		boolean r2 = turnSlot(m, 0);
		assertTrue(!r2);
	}
	
	@Test
	public void testTurnSlot() {
		Memory m = new Memory(5);
		boolean r1 = turnSlot(m, 0);
		assertTrue(r1);
		boolean r2 = turnSlot(m, 1);
		assertTrue(r2);
	}
	
	@Test
	public void testSimplePlaythrough()
	{
		try {
			Memory m = new Memory(5);
			int result = m.TestGame();
			System.out.println("Game completed in " + result + " tries!");
		} catch (Exception e) {
			
		}
	}
	
	private boolean turnSlot(Memory m, int slot) {
		boolean result = m.turnSlot(slot);
		return result;
	}
}
