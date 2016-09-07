package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

	@Test
	public void testSameName() throws IllegalValueException {
		Name a = new Name("Test");
		Name b = new Name("Test");	
		
		assertTrue(a.isSimilar(b));
	}
	
	public void testDifferentCaptalizedName() throws IllegalValueException {
		Name a = new Name("Test");
		Name b = new Name("TEST");
		
		assertTrue(a.isSimilar(b));
	}
}
