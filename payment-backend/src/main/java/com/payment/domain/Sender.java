package com.payment.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Sender {
	@Id
	private String customerid;
	private String accountholdername;
	private double clearbalance;
	private String customeraddress, customercity, customertype;
	private boolean overdraftflag;

	public Sender(String customerid, String accountholdername, double clearbalance, String customeraddress,
			String customercity, String customertype, boolean overdraftflag) {
		super();
		this.customerid = customerid;
		this.accountholdername = accountholdername;
		this.clearbalance = clearbalance;
		this.customeraddress = customeraddress;
		this.customercity = customercity;
		this.customertype = customertype;
		this.overdraftflag = overdraftflag;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getAccountholdername() {
		return accountholdername;
	}

	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}

	public double getClearbalance() {
		return clearbalance;
	}

	public void setClearbalance(double clearbalance) {
		this.clearbalance = clearbalance;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getCustomercity() {
		return customercity;
	}

	public void setCustomercity(String customercity) {
		this.customercity = customercity;
	}

	public String getCustomertype() {
		return customertype;
	}

	public void setCustomertype(String customertype) {
		this.customertype = customertype;
	}

	public boolean isOverdraftflag() {
		return overdraftflag;
	}

	public void setOverdraftflag(boolean overdraftflag) {
		this.overdraftflag = overdraftflag;
	}

}
