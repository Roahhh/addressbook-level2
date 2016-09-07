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
	
	@Test
	public void testDifferentCaptalizedName() throws IllegalValueException {
		Name a = new Name("Test");
		Name b = new Name("TEST");
		
		assertTrue(a.isSimilar(b));
	}
	
	@Test
	public void testDifferentName() throws IllegalValueException {
		Name a = new Name("Test");
		Name b = new Name("Different Name");
		
		assertFalse(a.isSimilar(b));
	}
	
	@Test
	public void testSimilarName() throws IllegalValueException {
		Name a = new Name("Same Name");
		Name b = new Name("Different Name");
		
		assertTrue(a.isSimilar(b));
	}
	
	@Test
	public void testNameInDifferentOrder() throws IllegalValueException {
		Name a = new Name("Same Name");
		Name b = new Name("Name Same");
		
		assertTrue(a.isSimilar(b));
	}
}
