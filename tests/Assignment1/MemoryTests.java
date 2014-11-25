package Assignment1;

import org.junit.*;

import Assignment1.Memory;
import static org.mockito.Mockito.*;

public class MemoryTests {
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructor() throws IllegalArgumentException {
		new Memory(0);
	}
	
	@Test
	public void testMemorySize() {
		Memory mockedMemory = mock(Memory.class);
		when(mockedMemory.getPairs()).thenReturn(5);
		when(mockedMemory.getSlots()).thenReturn(10);
		
		assert(mockedMemory.getPairs() == 5);
		assert(mockedMemory.getSlots() == 10);
	}
	
}
