package org.opensmpp.core.pdu.tlv;

import org.opensmpp.charset.Charsets;
import org.opensmpp.core.util.ArrayUtils;

public final class Types {

	public static final Type<Byte> BYTE = new ByteType();
	public static final Type<Void> EMPTY = new EmptyType();
	public static final Type<Integer> INTEGER = new IntegerType();
	public static final Type<Short> OCTET = new OctetType();
	public static final Type<Byte[]> OCTETS = new OctetsType();
	public static final Type<Short> SHORT = new ShortType();
	public static final Type<String> STRING = new StringType();

	private static class ByteType extends Type<Byte> {
		public ByteType() {
			super("byte");
		}

		@Override
		public byte[] serialize(Byte value) {
			return new byte[] { value.byteValue() };
		}

		@Override
		public Byte deserialize(byte[] bytes) {
			// FIXME: assert bytes length

			return bytes[0];
		}
	}

	private static class EmptyType extends Type<Void> {
		public EmptyType() {
			super("empty");
		}

		@Override
		public byte[] serialize(Void value) {
			return new byte[] {};
		}

		@Override
		public Void deserialize(byte[] bytes) {
			return null;
		}
	}

	private static class IntegerType extends Type<Integer> {
		public IntegerType() {
			super("int");
		}

		@Override
		public byte[] serialize(Integer value) {
			byte[] bytes = new byte[4];
			bytes[3] = (byte)(value & 0xff);
			bytes[2] = (byte)((value >>> 8) & 0xff);
			bytes[1] = (byte)((value >>> 16) & 0xff);
			bytes[0] = (byte)((value >>> 24) & 0xff);
			return bytes;
		}

		@Override
		public Integer deserialize(byte[] bytes) {
			// FIXME: assert bytes length

			int result = bytes[0] & 0xff;
			result <<= 8;
			result |= bytes[1] & 0xff;
			result <<= 8;
			result |= bytes[2] & 0xff;
			result <<= 8;
			result |= bytes[3] & 0xff;
			result <<= 8;
			return result;
		}
	}

	private static final class OctetType extends Type<Short> {
		public OctetType() {
			super("byte");
		}

		@Override
		public byte[] serialize(Short value) {
			return new byte[] { (byte) (value < 128 ? value : ( - (256 - value))) };
		}

		@Override
		public Short deserialize(byte[] bytes) {
			// FIXME: assert bytes length

			return (short) (bytes[0] >= 0 ? bytes[0] : (256 + (short) bytes[0]));
		}
	}

	private static final class OctetsType extends Type<Byte[]> {
		public OctetsType() {
			super("oct");
		}

		@Override
		public byte[] serialize(Byte[] value) {
			return ArrayUtils.toPrimitive(value);
		}

		@Override
		public Byte[] deserialize(byte[] bytes) {
			return ArrayUtils.toObject(bytes);
		}

		@Override
		public String toString(Byte[] bytes) {
			StringBuilder sb = new StringBuilder();
			for (Byte bite : bytes) {
				sb.append(String.format("%02x", bite));
			}
			return sb.toString();
		}
	}

	private static final class ShortType extends Type<Short> {
		public ShortType() {
			super("short");
		}

		@Override
		public byte[] serialize(Short value) {
			byte[] bytes = new byte[2];
			bytes[1] = (byte) (value & 0xff);
			bytes[0] = (byte)((value >>> 8) & 0xff);
			return bytes;
		}

		@Override
		public Short deserialize(byte[] bytes) {
			// FIXME: assert bytes length

			short result = 0;
			result |= bytes[0] & 0xff;
			result <<= 8;
			result |= bytes[1] & 0xff;
			return result;
		}
	}

	private static final class StringType extends Type<String> {
		public StringType() {
			super("str");
		}

		@Override
		public byte[] serialize(String value) {
			return ArrayUtils.add(value.getBytes(Charsets.US_ASCII), (byte) 0x00);
		}

		@Override
		public String deserialize(byte[] bytes) {
			// FIXME: assert bytes length
			// FIXME: assert null terminator
			
			return new String(ArrayUtils.subarray(bytes, 0, bytes.length - 2), Charsets.US_ASCII);
		}
	}
}
