package org.opensmpp.core.pdu.tlv;

import org.opensmpp.core.pdu.tlv.Tag.Validator;

public final class Tags {

	/**
	 * The additional_status_info_text parameter gives an ASCII textual
	 * description of the meaning of a response PDU. It is to be used by an
	 * implementation to allow easy diagnosis of problems.
	 * <p>
	 * Tag: 0x001d
	 */
	public static final Tag<String> ADDITIONAL_STATUS_INFO_TEXT = Tag.of(0x001d, Types.STRING);

	/**
	 * The alert_on_message_delivery parameter is set to instruct a MS to
	 * alert the user (in a MS implementation specific manner) when the short
	 * message arrives at the MS.
	 * <p>
	 * Tag: 0x130c
	 */
	public static final Tag<Void> ALERT_ON_MESSAGE_DELIVERY = Tag.of(0x130c, Types.EMPTY);

	/**
	 * The callback_num parameter associates a call back number with the
	 * message. In TDMA networks, it is possible to send and receive multiple
	 * callback numbers to/from TDMA mobile stations.
	 * <p>
	 * Tag: 0x0381
	 * <p>
	 * Value: see §5.3.2.36
	 */
	public static final Tag<Byte[]> CALLBACK_NUM = Tag.of(0x0381, Types.OCTETS);

	/**
	 * The callback_num_atag parameter associates an alphanumeric display with
	 * the call back number.
	 * <p>
	 * Tag: 0x0303
	 * <p>
	 * Value: see §5.3.2.38
	 */
	public static final Tag<Byte[]> CALLBACK_NUM_ATAG = Tag.of(0x0303, Types.OCTETS);

	/**
	 * Tag: 0x0302
	 */
	public static final Tag<Short> CALLBACK_NUM_PRES_IND = Tag.of(0x0302, Types.OCTET);

	/**
	 * The delivery_failure_reason parameter is used in the data_sm_resp
	 * operation to indicate the outcome of the message delivery attempt
	 * (only applicable for transaction message mode). If a delivery failure
	 * due to a network error is indicated, the ESME may check the
	 * network_error_code parameter (if present) for the actual network error
	 * code.
	 * <p>
	 * The delivery_failure_reason parameter is not included if the delivery
	 * attempt was successful.
	 * <p>
	 * Tag: 0x0425
	 * <p>
	 * Values:
	 * <li>0 = Destination unavailable
	 * <li>1 = Destination Address Invalid (e.g. suspended, no SMS capability, etc.)
	 * <li>2 = Permanent network error
	 * <li>3 = Temporary network error
	 * <li>values 4 to are 255 reserved
	 */
	public static final Tag<Short> DELIVERY_FAILURE_REASON = Tag.of(0x0425, Types.OCTET);

	/**
	 * The dest_addr_subunit parameter is used to route messages when received
	 * by a mobile station, for example to a smart card in the mobile station
	 * or to an external device connected to the mobile station.
	 * <p>
	 * Tag: 0x0005
	 * <p>
	 * Values
	 * <li>0x00 = Unknown (default)
	 * <li>0x01 = MS Display
	 * <li>0x02 = Mobile Equipment
	 * <li>0x03 = Smart Card 1 (expected to be SIM if a SIM exists in the MS)
	 * <li>0x04 = External Unit 1
	 * <li>5 to 255 = reserved
	 */
	public static final Tag<Short> DEST_ADDR_SUBUNIT = Tag.of(0x0005, Types.OCTET);

	/**
	 * The dest_bearer_type parameter is used to request the desired bearer for
	 * delivery of the message to the destination address. In the case that the
	 * receiving system (e.g. SMSC) does not support the indicated bearer type,
	 * it may treat this a failure and return a response PDU reporting a failure.
	 * <p>
	 * Tag: 0x0007
	 * <p>
	 * Values:
	 * <li>0x00 = Unknown
	 * <li>0x01 = SMS
	 * <li>0x02 = Circuit Switched Data (CSD)
	 * <li>0x03 = Packet Data
	 * <li>0x04 = USSD
	 * <li>0x05 = CDPD
	 * <li>0x06 = DataTAC
	 * <li>0x07 = FLEX/ReFLEX
	 * <li>0x08 = Cell Broadcast (cellcast)
	 * <li>9 to 255 = reserved
	 */
	public static final Tag<Short> DEST_BEARER_TYPE = Tag.of(0x0007, Types.OCTET);

	/**
	 * The dest_subaddress parameter specifies a subaddress associated with the
	 * destination of the message.
	 * <p>
	 * Tag: 0x0203
	 * <p>
	 * Value: See §5.3.2.16
	 */
	public static final Tag<Byte[]> DEST_SUBADDRESS = Tag.of(0x0203, Types.OCTETS);

	/**
	 * This parameter defines the telematic interworking to be used by the
	 * delivering system for the destination address. This is only useful when
	 * a specific dest_bearer_type parameter has also been specified as the
	 * value is bearer dependent. In the case that the receiving system
	 * (e.g. SMSC) does not support the indicated telematic interworking, it
	 * may treat this a failure and return a response PDU reporting a failure.
	 * <p>
	 * Tag: 0x0008
	 * <p>
	 * Value <i>to be defined</i>
	 */
	public static final Tag<Short> DEST_TELEMATICS_ID = Tag.of(0x0008, Types.SHORT);

	/**
	 * The dest_network_type parameter is used to indicate a network type
	 * associated with the destination address of a message. In the case that
	 * the receiving system (e.g. SMSC) does not support the indicated network
	 * type, it may treat this a failure and return a response PDU reporting a
	 * failure.
	 * <p>
	 * Tag: 0x0006
	 * <p>
	 * Values:
	 * <li>0x00 = Unknown
	 * <li>0x01 = GSM
	 * <li>0x02 = ANSI-136/TDMA
	 * <li>0x03 = IS-95/CDMA
	 * <li>0x04 = PDC
	 * <li>0x05 = PHS
	 * <li>0x06 = iDEN
	 * <li>0x07 = AMPS
	 * <li>0x08 = Paging Network
	 * <li>9 to 255 = reserved
	 */
	public static final Tag<Short> DEST_NETWORK_TYPE = Tag.of(0x0006, Types.OCTET);

	/**
	 * The destination_port parameter is used to indicate the application port
	 * number associated with the destination address of the message.
	 * <p>
	 * Tag: 0x020b
	 */
	public static final Tag<Short> DESTINATION_PORT = Tag.of(0x020b, Types.SHORT);

	/**
	 * The display_time parameter is used to associate a display time of the
	 * short message on the MS.
	 * <p>
	 * Tag: 0x1201
	 * <p>
	 * Values:
	 * <li>0 = Temporary
	 * <li>1 = Default (default)
	 * <li>2 = Invoke
	 * <li>values 3 to 255 are reserved
	 */
	public static final Tag<Short> DISPLAY_TIME = Tag.of(0x1201, Types.OCTET);

	/**
	 * The dpf_result parameter is used in the data_sm_resp PDU to indicate if
	 * delivery pending flag (DPF) was set for a delivery failure of the short
	 * message..
	 * <p>
	 * If the dpf_result parameter is not included in the data_sm_resp PDU, the
	 * ESME should assume that DPF is not set.
	 * <p>
	 * Currently this parameter is only applicable for the Transaction message
	 * mode.
	 * <p>
	 * Tag: 0x0420
	 * <p>
	 * Values:
	 * <li>0 = DPF not set
	 * <li>1 = DPF set
	 * <li>values 2 to 255 are reserved
	 */
	public static final Tag<Short> DPF_RESULT = Tag.of(0x0420, Types.OCTET);

	/**
	 * The its_reply_type parameter is a required parameter for the CDMA
	 * Interactive Teleservice as defined by the Korean PCS carriers [KORITS].
	 * It indicates and controls the MS user’s reply method to an SMS
	 * delivery message received from the ESME.
	 * <p>
	 * Tag: 0x1380
	 * <p>
	 * Values:
	 * <li>0 = Digit
	 * <li>1 = Number
	 * <li>2 = Telephone No.
	 * <li>3 = Password
	 * <li>4 = Character Line
	 * <li>5 = Menu
	 * <li>6 = Date
	 * <li>7 = Time
	 * <li>8 = Continue
	 * <li>values 9 to 255 are reserved
	 */
	public static final Tag<Short> ITS_REPLY_TYPE = Tag.of(0x1380, Types.OCTET);

	/**
	 * The its_session_info parameter is a required parameter for the CDMA
	 * Interactive Teleservice as defined by the Korean PCS carriers [KORITS].
	 * It contains control information for the interactive session between an
	 * MS and an ESME.
	 * <p>
	 * Tag: 0x1383
	 * <p>
	 * Value: see §5.3.2.43
	 */
	public static final Tag<Byte[]> ITS_SESSION_INFO = Tag.of(0x1383, Types.OCTETS);

	/**
	 * The language_indicator parameter is used to indicate the language of the
	 * short message.
	 * <p>
	 * Tag: 0x020d
	 * <p>
	 * Values:
	 * <li>0 = unspecified (default)
	 * <li>1 = english
	 * <li>2 = french
	 * <li>3 = spanish
	 * <li>4 = german
	 * <li>5 = Portuguese
	 * <li>refer to [CMT-136] for other values
	 */
	public static final Tag<Short> LANGUAGE_INDICATOR = Tag.of(0x020d, Types.OCTET);

	/**
	 * The message_payload parameter contains the user data.
	 * <p>
	 * Tag: 0x0424
	 */
	public static final Tag<Byte[]> MESSAGE_PAYLOAD = Tag.of(0x0424, Types.OCTETS);

	/**
	 * The message_state optional parameter is used by the SMSC in the
	 * deliver_sm and data_sm PDUs to indicate to the ESME the final message
	 * state for an SMSC Delivery Receipt.
	 * <p>
	 * Tag: 0x0427
	 * <p>
	 * Values:
	 * <li>1 = ENROUTE (The message is in enroute state)
	 * <li>2 = DELIVERED (Message is delivered to destination)
	 * <li>3 = EXPIRED (Message validity period has expired)
	 * <li>4 = DELETED (Message has been deleted)
	 * <li>5 = UNDELIVERABLE(Message is undeliverable)
	 * <li>6 = ACCEPTED (Message is in accepted state; i.e. has been manually read on behalf of the subscriber by customer service)
	 * <li>7 = UNKNOWN (Message is in invalid state)
	 * <li>8 = REJECTED (Message is in a rejected state)
	 */
	public static final Tag<Short> MESSAGE_STATE = Tag.of(0x0427, Types.OCTET);

	/**
	 * The more_messages_to_send parameter is used by the ESME in the submit_sm
	 * and data_sm operations to indicate to the SMSC that there are further
	 * messages for the same destination SME. The SMSC may use this setting for
	 * network resource optimization.
	 * <p>
	 * Tag: 0x0426
	 * <p>
	 * Values:
	 * <li>0 = No more messages to follow
	 * <li>1 = More messages to follow (default)
	 * <li>values 2 to 255 are reserved
	 */
	public static final Tag<Short> MORE_MESSAGES_TO_SEND = Tag.of(0x0426, Types.OCTET);

	/**
	 * The ms_availability_status parameter is used in the alert_notification
	 * operation to indicate the availability state of the MS to the ESME.
	 * <p>
	 * If the SMSC does not include the parameter in the alert_notification
	 * operation, the ESME should assume that the MS is in an “available” state.
	 * <p>
	 * Tag: 0x0422
	 * <p>
	 * Values:
	 * <li>0 = Available (Default)
	 * <li>1 = Denied (e.g. suspended, no SMS capability, etc.)
	 * <li>2 = Unavailable
	 * <li>values 3 to 255 are reserved
	 */
	public static final Tag<Short> MS_AVAILABILITY_STATUS = Tag.of(0x0422, Types.OCTET);

	/**
	 * The ms_msg_wait_facilities parameter allows an indication to be provided
	 * to an MS that there are messages waiting for the subscriber on systems on
	 * the PLMN. The indication can be an icon on the MS screen or other MMI
	 * indication.
	 * <p>
	 * The ms_msg_wait_facilities can also specify the type of message associated
	 * with the message waiting indication.
	 * <p>
	 * Tag: 0x0030
	 */
	public static final Tag<Short> MS_MSG_WAIT_FACILITIES = Tag.of(0x0030, Types.OCTET);

	/**
	 * The ms_validity parameter is used to provide an MS with validity
	 * information associated with the received short message.
	 * <p>
	 * Tag: 0x1204
	 * <p>
	 * Values:
	 * <li>0 = Store Indefinitely (default)
	 * <li>1 = Power Down
	 * <li>2 = SID based registration area
	 * <li>3 = Display Only
	 * <li>values 4 to 255 are reserved
	 */
	public static final Tag<Byte> MS_VALIDITY = Tag.of(0x1204, Types.BYTE, new RangeValidator<Byte>((byte) 0, (byte) 3));

	/**
	 * The network_error_code parameter is used to indicate the actual network
	 * error code for a delivery failure. The network error code is technology
	 * specific.
	 * <p>
	 * Tag: 0x0423
	 * <p>
	 * Value: see §5.3.2.31
	 */
	public static final Tag<Byte[]> NETWORK_ERROR_CODE = Tag.of(0x0423, Types.OCTETS);

	/**
	 * The number_of_messages parameter is used to indicate the number of
	 * messages stored in a mailbox.
	 * <p>
	 * Tag: 0x0304
	 * <p>
	 * Values:
	 * <li>0 to 99 = allowed values.
	 * <li>values 100 to 255 are reserved
	 */
	public static final Tag<Short> NUMBER_OF_MESSAGES = Tag.of(0x0304, Types.OCTET);

	/**
	 * The payload_type parameter defines the higher layer PDU type contained
	 * in the message payload.
	 * <p>
	 * Tag: 0x0019
	 * <p>
	 * Values:
	 * <li>0 = Default. In the case of a WAP application, the default higher
	 *         layer message type is a WDP message. See [WDP] for detail 
	 * <li>1 = WCMP message. Wireless Control Message Protocol formatted data.
	 *         See [WCMP] for details.
	 * <li>values 2 to 255 are reserved
	 */
	public static final Tag<Short> PAYLOAD_TYPE = Tag.of(0x0019, Types.OCTET);

	/**
	 * The privacy_indicator indicates the privacy level of the message.
	 * <p>
	 * Tag: 0x0201
	 * <p>
	 * Values:
	 * <li>0 = Privacy Level 0 (Not Restricted) (default)
	 * <li>1 = Privacy Level 1 (Restricted)
	 * <li>2 = Privacy Level 2 (Confidential)
	 * <li>3 = Privacy Level 3 (Secret)
	 * <li>values 4 to 255 are reserved
	 */
	public static final Tag<Short> PRIVACY_INDICATOR = Tag.of(0x0201, Types.OCTET);

	/**
	 * This parameter defines the number of seconds which the sender requests
	 * the SMSC to keep the message if undelivered before it is deemed expired
	 * and not worth delivering. If the parameter is not present, the SMSC may
	 * apply a default value.
	 * <p>
	 * Tag: 0x0017
	 */
	public static final Tag<Integer> QOS_TIME_TO_LIVE = Tag.of(0x0017, Types.INTEGER);

	/**
	 * The receipted_message_id parameter indicates the ID of the message being
	 * receipted in an SMSC Delivery Receipt. This is the opaque SMSC message
	 * identifier that was returned in the message_id parameter of the SMPP
	 * response PDU that acknowledged the submission of the original message.
	 * <p>
	 * Tag: 0x001e
	 */
	public static final Tag<String> RECEIPTED_MESSAGE_ID = Tag.of(0x001e, Types.STRING, new Validator<String>() {
		public boolean validate(String value) {
			return value != null && value.length() > 0 && value.length() < 66;
		}
	});

	/**
	 * The sar_msg_ref_num parameter is used to indicate the reference number
	 * for a particular concatenated short message.
	 * <p>
	 * Tag: 0x020c
	 */
	public static final Tag<Short> SAR_MSG_REF_NUM = Tag.of(0x020c, Types.SHORT);

	/**
	 * The sar_segment_seqnum parameter is used to indicate the sequence
	 * number of a particular short message within the concatenated short message.
	 * <p>
	 * Tag: 0x020f
	 */
	public static final Tag<Short> SAR_SEGMENT_SEQNUM = Tag.of(0x020f, Types.OCTET);

	/**
	 * The sar_total_segments parameter is used to indicate the total number of
	 * short messages within the concatenated short message.
	 * <p>
	 * Tag: 0x020e
	 * <p>
	 * This parameter shall contain a value in the range 1 to 255 indicating the
	 * total number of fragments within the concatenated short message. The value
	 * shall start at 1 and remain constant for every short message which makes
	 * up the concatenated short message.
	 * <p>
	 * When present, the PDU must also contain the sar_msg_ref_num and
	 * sar_segment_seqnum parameters. Otherwise this parameter shall be ignored.
	 */
	public static final Tag<Short> SAR_TOTAL_SEGMENTS = Tag.of(0x020e, Types.OCTET);

	/**
	 * The sc_interface_version parameter is used to indicate the SMPP version
	 * supported by the SMSC. It is returned in the bind response PDUs.
	 * <p>
	 * Tag: 0x0210
	 * <p>
	 * Values:
	 * <li>0x00-0x33 = Indicates that the EMSE supports version 3.3 or earlier of the SMPP protocol.
	 * <li>0x34 = Indicates that the ESME is supporting SMPP version 3.4
	 * <li>All other values reserved
	 */
	public static final Tag<Byte> SC_INTERFACE_VERSION = Tag.of(0x0210, Types.BYTE, new RangeValidator<Byte>((byte) 0, (byte) 0x34));

	/**
	 * An ESME may use the set_dpf parameter to request the setting of a
	 * delivery pending flag (DPF) for certain delivery failure scenarios,
	 * such as
	 * "MS is unavailable for message delivery (as indicated by the HLR)"
	 * <p>
	 * The SMSC should respond to such a request with an alert_notification PDU
	 * when it detects that the destination MS has become available.
	 * <p>
	 * The delivery failure scenarios under which DPF is set is SMSC
	 * implementation and network implementation specific. If a delivery
	 * pending flag is set by the SMSC or network (e.g. HLR), then the SMSC
	 * should indicate this to the ESME in the data_sm_resp message via the
	 * dpf_result parameter.
	 * <p>
	 * Tag: 0x0421
	 * <p>
	 * Values:
	 * <li>0 = Setting of DPF for delivery failure to MS not requested
	 * <li>1 = Setting of DPF for delivery failure requested (default)
	 * <li>values 2 to 255 are reserved
	 */
	public static final Tag<Short> SET_DPF = Tag.of(0x0421, Types.OCTET);

	/**
	 * The sms_signal parameter is used to provide a TDMA MS with alert tone
	 * information associated with the received short message.
	 * <p>
	 * Tag: 0x1203
	 * <p>
	 * Value: Encoded as per [CMT-136]
	 */
	public static final Tag<Short> SMS_SIGNAL = Tag.of(0x1203, Types.SHORT);

	/**
	 * The source_addr_subunit parameter is used to indicate where a message
	 * originated in the mobile station, for example a smart card in the mobile
	 * station or an external device connected to the mobile station.
	 * <p>
	 * Tag: 0x000d
	 * <p>
	 * Values: see {@link #DEST_ADDR_SUBUNIT}
	 */
	public static final Tag<Short> SOURCE_ADDR_SUBUNIT = Tag.of(0x000d, Types.OCTET);

	/**
	 * The source_bearer_type parameter indicates the wireless bearer over
	 * which the message originated.
	 * <p>
	 * Tag: 0x000f
	 * <p>
	 * Values: see {@link #DEST_BEARER_TYPE}
	 */
	public static final Tag<Short> SOURCE_BEARER_TYPE = Tag.of(0x000f, Types.OCTET);

	/**
	 * The source_network_type parameter is used to indicate the network type
	 * associated with the device that originated the message.
	 * <p>
	 * Tag: 0x000e
	 * <p>
	 * Values: see {@link #DEST_NETWORK_TYPE}
	 */
	public static final Tag<Short> SOURCE_NETWORK_TYPE = Tag.of(0x000e, Types.OCTET);

	/**
	 * The source_subaddress parameter specifies a subaddress associated with
	 * the originator of the message.
	 * <p>
	 * Tag: 0x0202
	 * <p>
	 * Value: See §5.3.2.15
	 */
	public static final Tag<Byte[]> SOURCE_SUBADDRESS = Tag.of(0x0202, Types.OCTETS);

	/**
	 * The source_telematics_id parameter indicates the type of telematics
	 * interface over which the message originated.
	 * <p>
	 * Tag: 0x0010
	 * <p>
	 * Value: see {@link #DEST_TELEMATICS_ID}
	 */
	public static final Tag<Short> SOURCE_TELEMATICS_ID = Tag.of(0x0010, Types.SHORT);

	/**
	 * The source_port parameter is used to indicate the application port
	 * number associated with the source address of the message.
	 * <p>
	 * Tag: 0x020a
	 */
	public static final Tag<Short> SOURCE_PORT = Tag.of(0x020a, Types.SHORT);

	/**
	 * A reference assigned by the originating SME to the short message.
	 * <p>
	 * Tag: 0x0204
	 */
	public static final Tag<Short> USER_MESSAGE_REFERENCE = Tag.of(0x0204, Types.SHORT);

	/**
	 * A response code set by the user in a User Acknowledgement/Reply message.
	 * The response codes are application specific.
	 * <p>
	 * Tag: 0x0205
	 */
	public static final Tag<Short> USER_RESPONSE_CODE = Tag.of(0x0205, Types.OCTET);

	/**
	 * The ussd_service_op parameter is required to define the USSD service
	 * operation when SMPP is being used as an interface to a (GSM) USSD system.
	 * <p>
	 * Tag: 0x0501
	 * <p>
	 * Values:
	 * <li>0 = PSSD indication
	 * <li>1 = PSSR indication
	 * <li>2 = USSR request
	 * <li>3 = USSN request
	 * <li>4 to 15 = reserved
	 * <li>16 = PSSD response
	 * <li>17 = PSSR response
	 * <li>18 = USSR confirm
	 * <li>19 = USSN confirm
	 * <li>20 to 31 = reserved
	 * <li>32 to 255 = reserved for vendor specific USSD operations
	 */
	public static final Tag<Short> USSD_SERVICE_OP = Tag.of(0x0501, Types.OCTET);

	private static class RangeValidator<T extends Comparable<T>> implements Validator<T> {
		private final T min;
		private final T max;
		public RangeValidator(T min, T max) {
			this.min = min;
			this.max = max;
		}
		public boolean validate(T value) {
			return value.compareTo(min) >= 0 && value.compareTo(max) <= 0;
		}
		@Override
		public String toString() {
			return String.format("RangeValidator{min=%d, max=%d}", min, max);
		}
	}
}
