package org.opensmpp.core.pdu.tlv;

import static org.fest.assertions.api.Assertions.*;

import org.junit.Ignore;
import org.junit.Test;

import org.smpp.pdu.tlv.TLV;
import org.smpp.pdu.tlv.TLVByte;
import org.smpp.pdu.tlv.TLVEmpty;
import org.smpp.pdu.tlv.TLVInt;
import org.smpp.pdu.tlv.TLVOctets;
import org.smpp.pdu.tlv.TLVShort;
import org.smpp.pdu.tlv.TLVString;
import org.smpp.pdu.tlv.TLVUByte;
import org.smpp.util.ByteBuffer;

public class DebugStringCompatibilityTest {

	private TLV logica;
	private Tlv<?,?> tlv;

	@Test
	@Ignore
	public void test() {
		Tlv.of(Tags.MS_VALIDITY, (byte) 3);
	}

	@Test
	public void testByte() {
		logica = new TLVByte((short) 0x0210, (byte) 0x34);
		tlv = Tlv.of(Tags.SC_INTERFACE_VERSION, (byte) 0x34);
		assertDebugStringEquals(logica, tlv);
	}

	@Test
	public void testEmpty() {
		logica = new TLVEmpty((short) 0x130c);
		tlv = Tlv.of(Tags.ALERT_ON_MESSAGE_DELIVERY);
		assertDebugStringEquals(logica, tlv);
	}

	@Test
	public void testInteger() {
		logica = new TLVInt((short) 0x0017, 1234);
		tlv = Tlv.of(Tags.QOS_TIME_TO_LIVE, 1234);
		assertDebugStringEquals(logica, tlv);
	}

	@Test
	public void testOctets() throws Exception {
		byte[] bytes = new byte[] { 0x01, 0x02, 0x03 };
		logica = new TLVOctets((short) 0x0424, new ByteBuffer(bytes));
		tlv = Tlv.of(Tags.MESSAGE_PAYLOAD, bytes);
		assertDebugStringEquals(logica, tlv);
	}

	@Test
	public void testShort() {
		logica = new TLVShort((short) 0x020a, (short) 1234);
		tlv = Tlv.of(Tags.SOURCE_PORT, (short) 1234);
		assertDebugStringEquals(logica, tlv);
	}

	@Test
	public void testString() throws Exception {
		logica = new TLVString((short) 0x001e, "abcd");
		tlv = Tlv.of(Tags.RECEIPTED_MESSAGE_ID, "abcd");
		assertDebugStringEquals(logica, tlv);
	}

	@Test
	public void testOctet() throws Exception {
		TLVUByte logica = new TLVUByte((short) 0x020e);
		logica.setValue((short) 123);

		tlv = Tlv.of(Tags.SAR_TOTAL_SEGMENTS, (short) 123);
		assertDebugStringEquals(logica, tlv);
	}

	private void assertDebugStringEquals(TLV logica, Tlv<?,?> tlv) {
		assertThat(tlv.toString()).isEqualTo(logica.debugString());
	}
}
