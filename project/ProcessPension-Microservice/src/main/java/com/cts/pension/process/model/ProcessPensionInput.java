package com.cts.pension.process.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProcessPensionInput {

	private long aadharnumber;
	
	
	public ProcessPensionInput(long aadharnumber, double pesionamount, double bankcharge) {
		super();
		this.aadharnumber = aadharnumber;
		this.pesionamount = pesionamount;
		this.bankcharge = bankcharge;
	}
	
	public long getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(long aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	public double getPesionamount() {
		return pesionamount;
	}
	public void setPesionamount(double pesionamount) {
		this.pesionamount = pesionamount;
	}
	public double getBankcharge() {
		return bankcharge;
	}
	public void setBankcharge(double bankcharge) {
		this.bankcharge = bankcharge;
	}
	private double pesionamount;
	private double bankcharge;
	
	
}
