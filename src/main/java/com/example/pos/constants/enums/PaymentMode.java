package com.example.pos.constants.enums;

/**
 * @author mandeepsingh
 *
 */
public enum PaymentMode {

	CASH(1, "CASH"), CARD(2, "CARD");

	private String name;
	private int value;

	private PaymentMode(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getName(int val) {
		for (PaymentMode paymentMode : PaymentMode.values()) {
			if (paymentMode.value == val) {
				return paymentMode.name;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
