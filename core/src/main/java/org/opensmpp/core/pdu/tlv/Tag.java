package org.opensmpp.core.pdu.tlv;

public class Tag<V> {

	public static <V> Tag<V> of(int id, Type<V> type) {
		return new Tag<V>(id, type, null);
	}
	public static <V> Tag<V> of(int id, Type<V> type, Validator<V> validator) {
		return new Tag<V>(id, type, validator);
	}

	private final short id;
	private final Type<V> type;
	private final Validator<V> validator;

	protected Tag(int id, Type<V> type, Validator<V> validator) {
		// FIXME: validate id range
		this.id = (short) id;
		this.type = type;
		this.validator = validator;
	}

	public short getTagId() {
		return id;
	}
	public Type<V> getValueType() {
		return this.type;
	}
	public boolean validate(V value) {
		return this.validator != null ? this.validator.validate(value) : true;
	}

	@Override
	public String toString() {
		return String.format("Tag{id=%d, type=%s, validator=%s}", this.id, this.type, this.validator);
	}

	public String toString(V value) {
		return new StringBuilder()
			.append("(")
			.append(this.type.getLabel())
			.append(": (tlv: ")
			.append(this.id)
			.append(") ")
			.append(value == null ? "" : this.type.toString(value))
			.append(") ")
			.toString();
	}

	public byte[] toBytes(V value) {
		return this.type.serialize(value);
	}

	public static interface Validator<V> {
		boolean validate(V value);
	}
}
