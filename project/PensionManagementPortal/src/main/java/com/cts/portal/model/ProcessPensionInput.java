package com.cts.portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcessPensionInput {

	private long aadharnumber;
	public long getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(long aadharnumber) {
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
