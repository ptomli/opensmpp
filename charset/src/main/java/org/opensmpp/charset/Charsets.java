package org.opensmpp.charset;

import java.nio.charset.Charset;

public final class Charsets {
	public static final Charset GSM_03_38 = Charset.forName("X-Gsm7Bit");
	public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
	public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
	public static final Charset US_ASCII = Charset.forName("US-ASCII");

	private Charsets() {}
}
