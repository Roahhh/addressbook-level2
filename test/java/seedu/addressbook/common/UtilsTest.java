package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UtilsTest {
	@Test
	public void testNoNull() {
		assertFalse(Utils.isAnyNull("There", "are", "no", "nulls", 1, 5, false));
	}
}
