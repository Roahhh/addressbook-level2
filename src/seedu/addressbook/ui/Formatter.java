package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import java.util.List;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    public String getPromptForCommand() {
    	return LINE_PREFIX + "Enter command: ";
    }
    
    public String formatInputCommand(String inputCommand) {
    	return "[Command entered:" + inputCommand + "]";
    }
    
    public String[] getFormattedWelcomeMessage(String version, String storageFileInfo) {
    	return new String[]{ DIVIDER,
    						 DIVIDER,
    						 MESSAGE_WELCOME,
    						 version,
    						 MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
    						 storageFileInfo,
    						 DIVIDER
    						 };
    }
    
    public String[] getFormattedGoodbyeMessage() {
    	return new String[]{ MESSAGE_GOODBYE, 
    						 DIVIDER, 
    						 DIVIDER
    						 };
    }
    
    public String[] getFormattedInitFailedMessage() {
    	return new String[]{ MESSAGE_INIT_FAILED, 
    						 DIVIDER, 
    						 DIVIDER
    						 };
    }
    
    public String getFormattedOutputString(String string) {
    	return LINE_PREFIX + string.replace("\n", LS + LINE_PREFIX);
    }
    
    public String[] getFormattedFeedbackString(String string) {
    	return new String[] { string,
    						  DIVIDER
    						  };
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
