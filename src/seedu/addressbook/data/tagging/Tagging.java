package seedu.addressbook.data.tagging;

import java.util.ArrayList;


public class Tagging {
	final private static String PREFIX_ADDED = "+";
	final private static String PREFIX_DELETED = "-";
	final private static String PADDING = " ";
	
	private static ArrayList<String> processedTags;
	
	private boolean _isAdd;
	private String _personName;
	private String _tagName;
	
	public Tagging(boolean isAdd, String personName, String tagName) {
		_isAdd = isAdd;
		_personName = personName;
		_tagName = tagName;
		processedTags.add(this.toString());

	}
	
	@Override
	public String toString() {
		if (this._isAdd) {
			return PREFIX_ADDED + PADDING + this._personName + PADDING + "[" + this._tagName + "]";
		} else {
			return PREFIX_DELETED + PADDING + this._personName + PADDING + "[" + this._tagName + "]";			
		}
	}
	
	public static ArrayList<String> getProcessedTags() {
		return processedTags;
	}
}
