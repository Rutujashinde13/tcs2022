package com.cts.pension.disbursement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProcessPensionInput {
	private Long aadharnumber;
	public Long getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(Long aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	public double getPensionamount() {
		return pensionamount;
	}
	public void setPensionamount(double pensionamount) {
		this.pensionamount = pensionamount;
	}
	public double getBankcharge() {
		return bankcharge;
	}
	public void setBankcharge(double bankcharge) {
		this.bankcharge = bankcharge;
	}
	private double pensionamount;
	private double bankcharge;
}