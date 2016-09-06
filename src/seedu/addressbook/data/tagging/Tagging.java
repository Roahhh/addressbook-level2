package seedu.addressbook.data.tagging;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;


public class Tagging {
	final private static String PREFIX_ADDED = "+";
	final private static String PREFIX_DELETED = "-";
	final private static String PADDING = " ";
		
	private boolean _isAdd;
	private Person _person;
	private Tag _tag;
	
	public Tagging(boolean isAdd, Person person, Tag tag) {
		_isAdd = isAdd;
		_person = person;
		_tag = tag;
	}
	
	public static ArrayList<Tagging> processTaggings(Person person, UniqueTagList tags) {
		ArrayList<Tagging> taggings = new ArrayList<>();
		
		for(Tag tagRemoved : person.getTags()) {
			if(!tags.contains(tagRemoved)) {
				Tagging taggingRemoved = new Tagging(false, person, tagRemoved);
				taggings.add(taggingRemoved);
			}
		}
		
		for(Tag tagAdded : tags) {
			if(!person.getTags().contains(tagAdded)) {
				Tagging taggingAdded = new Tagging(true, person, tagAdded);
				taggings.add(taggingAdded);
			}
		}
		
		return taggings;
	}
	
	public static ArrayList<Tagging> processFirstAdd(Person person, UniqueTagList tags) {
		ArrayList<Tagging> taggings = new ArrayList<>();
		
		for (Tag tagAdded : tags) {
			Tagging taggingAdded = new Tagging(true, person, tagAdded);
			taggings.add(taggingAdded);
		}
		
		return taggings;
	}
	
	@Override
	public String toString() {
		if (this._isAdd) {
			return PREFIX_ADDED + PADDING + this._person.getName().toString() + PADDING + this._tag.toString();
		} else {
			return PREFIX_DELETED + PADDING + this._person.getName().toString() + PADDING + this._tag.toString();			
		}
	}
}
