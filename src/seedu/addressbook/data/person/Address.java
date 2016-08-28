package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the form of BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+, .+, .+, .+";
    
    private static final int ADDRESS_BLOCK_INDEX = 0;
    private static final int ADDRESS_STREET_INDEX = 1;
    private static final int ADDRESS_UNIT_INDEX = 2;
    private static final int ADDRESS_POSTAL_CODE_INDEX = 3;


    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        String[] addressArray = address.split(", ");
        this.block = new Block(addressArray[ADDRESS_BLOCK_INDEX]);
        this.street = new Street(addressArray[ADDRESS_STREET_INDEX]);
        this.unit = new Unit(addressArray[ADDRESS_UNIT_INDEX]);
        this.postalCode = new PostalCode(addressArray[ADDRESS_POSTAL_CODE_INDEX]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }
    
	public String getValue() {
		return block.getBlock() + ", " + street.getStreet() + ", " 
        	   + unit.getUnit() + ", " + postalCode.getPostalCode();
	}
    
    @Override
    public String toString() {
        return this.getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getValue().equals(((Address) other).getValue())); // state check
    }

    @Override
    public int hashCode() {
        return this.getValue().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}