package org.opensmpp.core.pdu.tlv;

import org.opensmpp.core.util.ArrayUtils;

public class Tlv<T extends Tag<V>, V> {
	public static <T extends Tag<V>, V> Tlv<T,V> of(T tag, V value) {
		if (!tag.validate(value)) {
			throw new IllegalArgumentException("Value " + value + " is not valid for the tag "  + tag);
		}
		return new Tlv<T,V>(tag, value);
	}

	// convenience method to create a Tag<Byte[]> type Tlv from a native byte[]
	// TODO: is this really useful, and should others like byte->Byte be created?
	public static <T extends Tag<Byte[]>> Tlv<T,Byte[]> of(T tag, byte[] value) {
		return Tlv.of(tag, ArrayUtils.toObject(value));
	}
	// convenience method to create a Tag<Void> type Tlv without needing a null value
	public static <T extends Tag<Void>> Tlv<T,Void> of(T tag) {
		return Tlv.of(tag, null);
	}

	private final T tag;
	private final V value;

	protected Tlv(T tag, V value) {
		this.tag = tag;
		this.value = value;
	}

	public Tag<V> getTag() {
		return this.tag;
	}

	public int getTagId() {
		return this.tag.getTagId();
	}

	public V getValue() {
		return this.value;
	}

	public byte[] toBytes() {
		byte[] header = new byte[4];
		byte[] data = this.tag.toBytes(this.value);

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
		return this.tag.equals(((Tlv<?,?>) o).tag);
	}

	@Override
	public int hashCode() {
		return this.tag.hashCode();
	}

	@Override
	public String toString() {
		return this.tag.toString(value);
	}
}
