package tsuboin_hw5;

/**
 * Immutable Data Class for video objects.
 * Comprises a triple: title, year, director.
 *
 * <p><b>Class Type:</b> Immutable Data Class</p>
 * <p><b>Object Invariant:</b></p>
 * Title is non-null, no leading or final spaces, not empty string.
 * <p><b>Object Invariant:</b></p>
 * Year is greater than 1800, less than 5000.
 * <p><b>Object Invariant:</b></p>
 * Director is non-null, no leading or final spaces, not empty string.
 */
final class VideoObj implements Comparable<VideoObj> {

	/**
	 * <p><b>Invariant:</b> non-null, no leading or final spaces, not empty string </p>
	 */
	private final String title;

	/**
	 * <p><b>Invariant:</b> greater than 1800, less than 5000 </p>
	 */
	private final int year;

	/**
	 * <p><b>Invariant:</b> non-null, no leading or final spaces, not empty string </p>
	 */
	private final String director;

	/**
	 * Initialize all object attributes.
	 * Title and director are "trimmed" to remove leading and final space.
	 *
	 * @throws IllegalArgumentException if any object invariant is violated.
	 */
	VideoObj(String title, int year, String director) {

		// Object invariant parameters
		final int MIN_YEAR = 1800;
		final int MAX_YEAR = 5000;
		boolean yearIsValid = year > MIN_YEAR && year < MAX_YEAR;


		// Check parameters are valid
		if (isInvalidString(title) || isInvalidString(director))
			throw new IllegalArgumentException("Invalid title or director - " +
				"cannot be empty or null");
		if (!yearIsValid)
			throw new IllegalArgumentException("Invalid year.");

		// Assign member fields
		this.title = title.trim();
		this.year = year;
		this.director = director.trim();
	}

	/**
	 * Return the value of the attribute.
	 */
	public String director() {
		return this.director;
	}

	/**
	 * Return the value of the attribute.
	 */
	public String title() {
		return this.title;
	}

	/**
	 * Return the value of the attribute.
	 */
	public int year() {
		return this.year;
	}

	/**
	 * Compare the attributes of this object with those of thatObject.
	 *
	 * @param thatObject the Object to be compared.
	 * @return deep equality test between this and thatObject.
	 */
	@Override
	public boolean equals(Object thatObject) {
		// Check if comparing this to that
		if (thatObject == this) return true;

		// Type check thatObject + null check
		if (!(thatObject instanceof VideoObj) || thatObject == null)
			return false;

		// Cast thatObject to VideoObj
		VideoObj that = (VideoObj) thatObject;

		// Compare field equality
		return (
				this.title.equals(that.title()) &&
				this.year == that.year &&
				this.director.equals(that.director())
				);
	}

	/**
	 * Return a hash code value for this object using the algorithm from Bloch:
	 * fields are added in the following order: title, year, director.
	 */
	@Override
	public int hashCode() {
		int hash = 1;        // integer hash code from fields
		final int F = 31;    // prime multiplication factor
		hash = this.title.toUpperCase().hashCode();
		hash = F * hash + Integer.hashCode(year);
		hash = F * hash + this.director.toUpperCase().hashCode();
		return hash;
	}

	/**
	 * Compares the attributes of this object with those of thatObject, in
	 * the following order: title, year, director.
	 * <p>
	 * //	 * @param that the VideoObj to be compared.
	 *
	 * @return a negative integer, zero, or a positive integer as this
	 * object is less than, equal to, or greater than that object.
	 */
	@Override
	public int compareTo(VideoObj thatObject) {
		int result = this.title.compareTo(thatObject.title());
		// if result of comparison shows fields are equal, keep comparing
		if (result == 0)
			result = Integer.compare(this.year, thatObject.year);
			if (result == 0)
				result = this.director.compareTo(thatObject.director());
		return result; // negative, zero, or positive integer
	}

	/**
	 * Return a string representation of the object in the following format:
	 * <code>"title (year) : director"</code>.
	 */
	@Override
	public String toString() {
//		return "El Mariachi (1996) : Rodriguez";
		return this.title + " (" + this.year + ") : " + this.director;
	}

	/* Private Methods */

	/**
	 * VideoObj object invariant helper function returns true if
	 * parameter is not null, and not an empty string.
	 *
	 * @param s of VideoObj constructor
	 * @return True if valid title
	 */
	boolean isInvalidString(String s) {
		// Check if null or empty
		return s == null || s.isBlank() || s.isEmpty();
	}
}
