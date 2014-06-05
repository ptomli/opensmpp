package org.opensmpp.core.pdu.tlv;

import org.opensmpp.core.util.ArrayUtils;

public class Tlv<V> {
	public static <V> Tlv<V> of(Tag<V> tag, V value) {
		if (!tag.validate(value)) {
			throw new IllegalArgumentException("Value " + value + " is not valid for the tag "  + tag);
		}
		return new Tlv<V>(tag, value);
	}

	// convenience method to create a Tag<Byte[]> type Tlv from a native byte[]
	// TODO: is this really useful, and should others like byte->Byte be created?
	public static Tlv<Byte[]> of(Tag<Byte[]> tag, byte[] value) {
		return Tlv.of(tag, ArrayUtils.toObject(value));
	}
	// convenience method to create a Tag<Void> type Tlv without needing a null value
	public static Tlv<Void> of(Tag<Void> tag) {
		return Tlv.of(tag, null);
	}

	private final Tag<V> tag;
	private final V value;

	protected Tlv(Tag<V> tag, V value) {
		this.tag = tag;
		this.value = value;
	}

	public Tag<V> getTag() {
		return tag;
	}

	public int getTagId() {
		return tag.getTagId();
	}

	public V getValue() {
		return value;
	}

	public byte[] toBytes() {
		byte[] header = new byte[4];
		byte[] data = tag.toBytes(value);

		// prepend tag id
		short id = tag.getTagId();
		header[1] = (byte) (id & 0xff);
		header[0] = (byte) ((id >>> 8) & 0xff);

		// prepend length
		// FIXME: validate length range
		short len = (short) data.length;
		header[3] = (byte) (len & 0xff);
		header[2] = (byte) ((len >>> 8) & 0xff);
		
		return ArrayUtils.concat(header, data);
	}

	/**
	 * Tlv is equal to another Tlv if their tags are equal.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Tlv)) {
			return false;
		}
		return tag.equals(((Tlv<?>) o).tag);
	}

	@Override
	public int hashCode() {
		return tag.hashCode();
	}

	@Override
	public String toString() {
		return tag.toString(value);
	}
}
