package org.opensmpp.core.pdu.tlv;

public abstract class Type<T> {

	private final String label;
	protected Type(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public abstract byte[] serialize(T value);
	public abstract T deserialize(byte[] bytes);
	
	public String toString(T value) {
		return value.toString();
	}
}
