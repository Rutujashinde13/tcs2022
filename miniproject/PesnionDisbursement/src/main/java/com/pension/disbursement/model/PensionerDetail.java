package com.pension.disbursement.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


public class PensionerDetail {

	private long aadharnumber;
	public long getAadharNumber() {
		return aadharnumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharnumber = aadharNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateofbirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateofbirth = dateOfBirth;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public double getSalaryEarned() {
		return salaryearned;
	}
	public void setSalaryEarned(double salaryEarned) {
		this.salaryearned = salaryEarned;
	}
	public double getAllowances() {
		return allowances;
	}
	public void setAllowances(double allowances) {
		this.allowances = allowances;
	}
	public String getPensionType() {
		return pensiontype;
	}
	public void setPensionType(String pensionType) {
		this.pensiontype = pensionType;
	}
	public String getBankName() {
		return bankname;
	}
	public void setBankName(String bankName) {
		this.bankname = bankName;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getBankType() {
		return banktype;
	}
	public void setBankType(String bankType) {
		this.banktype = bankType;
	}
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofbirth;
	private String pan;
	private double salaryearned;
	private double allowances;
	String pensiontype;
	private String bankname;
	private String accountnumber;
	private String banktype;
}
