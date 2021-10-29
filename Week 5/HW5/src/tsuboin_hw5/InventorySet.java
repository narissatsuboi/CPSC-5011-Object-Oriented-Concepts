package tsuboin_hw5;

import java.util.*;

/**
 * An Inventory implemented using a <code>HashMap&lt;Video, Record&gt;</code>.
 * Keys are Videos; Values are Records.
 *
 * <p><b>Class Type:</b> Mutable Collection of Records</p>
 * <p><b>Object Invariant:</b></p>
 * Every key and value in the map is non-<code>null</code>.
 * <p><b>Object Invariant:</b></p>
 * Each value <code>r</code> is stored under key <code>r.video</code>.
 */
final class InventorySet {

	/**
	 * <p><b>Invariant:</b> <code>_data != null</code> </p>
	 */
	private final Map<VideoObj, Record> data = new HashMap<VideoObj, Record>();

	/**
	 * Default constructor.
	 */
	InventorySet() {
	}

	/**
	 * Return the number of Records.
	 */
	public int size() {
		return data.size();
	}

	/**
	 * Return a copy of the record for a given Video; if not present, return <code>null</code>.
	 * @return Copy of record for Video v.
	 */
	public Record get(VideoObj v) {
		if (!data.containsKey(v))
			return null;
		return data.get(v).copy();
	}

	/**
	 * Return a copy of the records as a collection.
	 * Neither the underlying collection, nor the actual records are returned.
	 */
	public ArrayList<Record> toCollection() {

		// Stores Record copies
		ArrayList<Record> recordCollection = new ArrayList<>();

		// Iterate over data hashmap, adding a COPY of each record
		for (Record r : data.values()) {
			recordCollection.add(r.copy());
		}
		return recordCollection;
	}

	/**
	 * Add or remove copies of a video from the inventory.
	 * If a video record is not already present (and change is
	 * positive), a record is created.
	 * If a record is already present, <code>numOwned</code> is
	 * modified using <code>change</code>.
	 * If <code>change</code> brings the number of copies to be zero,
	 * the record is removed from the inventory.
	 *
	 * @param video  the video to be added.
	 * @param change the number of copies to add (or remove if negative).
	 * @throws IllegalArgumentException if video null, change is zero,
	 *                                  if attempting to remove more copies than are owned, or if
	 *                                  attempting to remove copies that are checked out.
	 *                                  <p><b>Postcondition:</b> changes the record for the video</p>
	 */
	public void addNumOwned(VideoObj video, int change) {
		// Video is null
		if (video == null)
			throw new IllegalArgumentException("Video cannot be null.");

		// Video isn't already in the inventory and the change is neg
		if (!data.containsKey(video) && change < 0)
			throw new IllegalArgumentException("Video does not exist in " +
				"inventory, cannot remove copies.");

		// Video is in the inventory but trying to remove more than are
		// owned
		if (data.containsKey(video) && change < 0
			&& data.get(video).numOwned < change)
			throw new IllegalArgumentException("Cannot remove more copies in " +
				"inventory than are owned");
		// If video isn't already in the inventory, add a new k:v pair
		if (!data.containsKey(video))
			data.put(video, new Record(video, change, 0, 0));
		// Video is already in the inventory, update numOwned
		else if (data.containsKey(video)) {
			Record swap = data.get(video);
			swap.numOwned += change;
			data.replace(video, swap);
		}
		// Remove k:v pair if v is 0
		if (data.get(video).numOwned == 0)
			data.remove(video);
	}

	/**
	 * Check out a video.
	 *
	 * @param video the video to be checked out.
	 * @throws IllegalArgumentException if video has no record or numOut
	 *                                  equals numOwned.
	 *                                  <p><b>Postcondition:</b> changes the record for the video</p>
	 */
	public void checkOut(VideoObj video) {

		// Don't carry that video in inventory
		if (!data.containsKey(video))
			throw new IllegalArgumentException("Sorry! We don't carry that " +
				"title at this time.");
		Record swap = data.get(video);
		// Carry the video but no copies available
		if (swap.numOut == swap.numOwned)
			throw new IllegalArgumentException("Sorry! That video is " +
				"unavailable.");
		// Otherwise, check out the video, update numOut, and store in data
		swap.numOut++;
		swap.numRentals++;
		data.replace(video, swap);
	}

	/**
	 * Check in a video.
	 *
	 * @param video the video to be checked in.
	 * @throws IllegalArgumentException if video has no record or numOut
	 *                                  non-positive.
	 *                                  <p><b>Postcondition:</b> changes the record for the video</p>
	 */
	public void checkIn(VideoObj video) {
		// Don't carry that video in inventory
		if (!data.containsKey(video))
			throw new IllegalArgumentException("Sorry! We don't carry that " +
				"title at this time. Make sure that title isn't from another " +
				"store!");

		Record swap = data.get(video);
		// We already have all our copies in inventory
		if (swap.numOut == 0)
			throw new IllegalArgumentException("Hm, looks like we already " +
				"have all our copies of that title accounted for. Make sure " +
				"that title isn't from another store!");

		// Otherwise, check in the video
		swap.numOut--;
		data.replace(video, swap);
	}

		/**
		 * Remove all records from the inventory.
		 * <p><b>Postcondition:</b> <code>size() == 0</code></p>
		 */
	public void clear() {
		data.clear();
	}

	/**
	 * Return the contents of the inventory as a string.
	 */
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Database:\n");
		for (Record r : data.values()) {
			buffer.append("  ");
			buffer.append(r);
			buffer.append("\n");
		}
		return buffer.toString();
	}

}