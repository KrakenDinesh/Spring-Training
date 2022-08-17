package com.payment.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message_code")
public class Message {
	@Id
	private String messagecode;
	private String instruction;

	public Message(String messagecode, String instruction) {
		super();
		this.messagecode = messagecode;
		this.instruction = instruction;
	}

	public String getMessagecode() {
		return messagecode;
	}

	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

}
