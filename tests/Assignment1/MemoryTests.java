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
		new Memory(11);
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
			MemorySlot realSlot = m.getSlot(i);
			assert(m.sameSlotValue(mockedSlot, realSlot));
		}
	}
	
}
