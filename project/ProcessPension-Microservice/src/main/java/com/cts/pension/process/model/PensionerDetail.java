package com.cts.pension.process.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PensionerDetail {
	
	private long aadharnumber;
	private String name;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dateofbirth;
	private String pan;
	private double salaryearned;
	private double allowances;
	private String pensiontype;
	private String bankname;
	private String accountnumber;
	private String banktype;

	
	//constructor for detalis 
	public PensionerDetail(long aadharnumber, String name, LocalDate dateofbirth, String pan, double salaryearned,
			double allowances, String pensiontype, String bankname, String accountnumber, String banktype) {
		super();
		this.aadharnumber = aadharnumber;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.pan = pan;
		this.salaryearned = salaryearned;
		this.allowances = allowances;
		this.pensiontype = pensiontype;
		this.bankname = bankname;
		this.accountnumber = accountnumber;
		this.banktype = banktype;
	}
	public long getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(long aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public double getSalaryearned() {
		return salaryearned;
	}
	public void setSalaryearned(double salaryearned) {
		this.salaryearned = salaryearned;
	}
	public double getAllowances() {
		return allowances;
	}
	public void setAllowances(double allowances) {
		this.allowances = allowances;
	}
	public String getPensiontype() {
		return pensiontype;
	}
	public void setPensiontype(String pensiontype) {
		this.pensiontype = pensiontype;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getBanktype() {
		return banktype;
	}
	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}
	
	
}
