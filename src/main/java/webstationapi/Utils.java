package webstationapi;

public class Utils {

	/*
	 * Parse a string to get an id as an int.
	 * If the parsing fails, it will return -1, indicating that an error occurred and that the id could not be determined.
	 * Otherwise, it will return the id as an int.
	 */
	public static int getIdFromString(String stringId) {
		int id;
		try { id = Integer.parseInt(stringId); }
		catch (NumberFormatException exception) {
			return -1;
		}
		return id;
	}
	
}
