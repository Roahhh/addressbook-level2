package seedu.addressbook.data.person;

public class Contact {
    public final String _value;
    private boolean _isPrivate;

    public Contact(String value, boolean isPrivate) {
    	this._value = value;
    	this._isPrivate = isPrivate;
    }
    
    public String toString() {
    	return _value;
    }
    
    public int hashCode() {
    	return _value.hashCode();
    }
    
    public boolean isPrivate() {
    	return _isPrivate;
    }
}
