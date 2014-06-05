package org.opensmpp.core.util;

public final class ArrayUtils {
	private static final byte[] EMPTY_BYTE_ARRAY = new byte[] {};
	private static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[] {};

	public static byte[] add(byte[] array, byte bite) {
		byte[] result = new byte[array.length + 1];
		System.arraycopy(array, 0, result, 0, array.length);
		result[array.length] = bite;
		return result;
	}

	public static byte[] concat(byte[] arg0, byte[] arg1) {
		if (arg0 == null) {
			return arg1 == null ? null : arg1.clone();
		}
		if (arg1 == null) {
			return arg0 == null ? null : arg0.clone();
		}
		byte[] result = new byte[arg0.length + arg1.length];
		System.arraycopy(arg0, 0, result, 0, arg0.length);
		System.arraycopy(arg1, 0, result, arg0.length, arg1.length);
		return result;
	}

	public static byte[] subarray(byte[] array, int start, int end) {
		if (array == null) {
			return null;
		}
		start = Math.max(start, 0);
		end = Math.min(end, array.length);

		int length = end - start;
		if (length <= 0) {
			return EMPTY_BYTE_ARRAY;
		}

		byte[] result = new byte[length];
		System.arraycopy(array, start, result, 0, length);
		return result;
	}

	public static byte[] toPrimitive(Byte[] array) {
		if (array == null) {
			return null;
		}
		if (array.length == 0) {
			return EMPTY_BYTE_ARRAY;
		}
		final byte[] result = new byte[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i].byteValue();
		}
		return result;
	}
	public static Byte[] toObject(byte[] array) {
		if (array == null) {
			return null;
		}
		if (array.length == 0) {
			return EMPTY_BYTE_OBJECT_ARRAY;
		}
		final Byte[] result = new Byte[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = Byte.valueOf(array[i]);
		}
		return result;
	}

	private ArrayUtils() {}	
}
