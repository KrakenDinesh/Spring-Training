package com.payment.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banks")
public class Bank {
	@Id
	private String bic;
	private String bankname;

	public Bank(String bic, String bankname) {
		super();
		this.bic = bic;
		this.bankname = bankname;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

}
