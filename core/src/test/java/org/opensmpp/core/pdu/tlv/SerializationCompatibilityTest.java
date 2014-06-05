package org.opensmpp.core.pdu.tlv;

import static org.fest.assertions.api.Assertions.*;

import org.junit.Test;

import org.smpp.pdu.tlv.TLVByte;
import org.smpp.pdu.tlv.TLVEmpty;
import org.smpp.pdu.tlv.TLVInt;
import org.smpp.pdu.tlv.TLVOctets;
import org.smpp.util.ByteBuffer;

public class SerializationCompatibilityTest {

	@Test
	public void testByte() throws Exception {
		TLVByte logica = new TLVByte(Tags.DELIVERY_FAILURE_REASON.getTagId(), (byte) 0x01);
		Tlv<Short> tlv = Tlv.of(Tags.DELIVERY_FAILURE_REASON, (short) 0x01);

		assertThat(tlv.toBytes()).isEqualTo(logica.getData().getBuffer());
	}

	@Test
	public void testEmpty() throws Exception {
		TLVEmpty logica = new TLVEmpty(Tags.ALERT_ON_MESSAGE_DELIVERY.getTagId(), true);
		Tlv<Void> tlv = Tlv.of(Tags.ALERT_ON_MESSAGE_DELIVERY, null);
		assertThat(tlv.toBytes()).isEqualTo(logica.getData().getBuffer());
	}

	@Test
	public void testInteger() throws Exception {
		TLVInt logica = new TLVInt(Tags.QOS_TIME_TO_LIVE.getTagId(), 1000);
		Tlv<Integer> tlv = Tlv.of(Tags.QOS_TIME_TO_LIVE, 1000);
		assertThat(tlv.toBytes()).isEqualTo(logica.getData().getBuffer());
	}

	@Test
	public void testOctets() throws Exception {
		ByteBuffer bb = new ByteBuffer(new byte[] { 0x01, 0x02, 0x03 });
		TLVOctets logica = new TLVOctets(Tags.MESSAGE_PAYLOAD.getTagId(), bb);
		Tlv<Byte[]> tlv = Tlv.of(Tags.MESSAGE_PAYLOAD, new byte[] { 0x01, 0x02, 0x03 });
		assertThat(tlv.toBytes()).isEqualTo(logica.getData().getBuffer());
	}

//	@Test
//	public void testLogicaSpeed() throws Exception {
//		TLVByte logica = null;
//		short tag = (short) 0x0425;
//		byte value = (byte) 0x01;
//		byte[] bytes = null;
//
//		for (int i = 0; i < 10000000; i++) {
//			logica = new TLVByte(tag, value);
//			bytes = logica.getData().getBuffer();
//		}
//		System.err.println(bytes);
//	}
//
//	@Test
//	public void testTlvSpeed() {
//		Tlv<Tag<Short>, Short> tlv = null;
//		Tag<Short> tag = Tags.DELIVERY_FAILURE_REASON;
//		short value = (short) 0x01;
//		byte[] bytes = null;
//
//		for (int i = 0; i < 10000000; i++) {
//			tlv = Tlv.of(tag, value);
//			bytes = tlv.toBytes();
//		}
//		System.err.println(bytes);
//	}
}
