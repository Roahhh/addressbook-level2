package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UtilsTest {
	@Test
	public void testNoNull() {
		assertFalse(Utils.isAnyNull("There", "are", "no", "nulls", 1, 5, false));
	}
	
	@Test
	public void testOneNull() {
		assertTrue(Utils.isAnyNull("There", "is", "one", null, 1, 5, true));
	}
	
	@Test
	public void testNonUnique() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(1);
		}
		
		assertFalse(Utils.elementsAreUnique(list));
	}
	
	@Test
	public void testAllUnique() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		
		assertTrue(Utils.elementsAreUnique(list));
	}
}
