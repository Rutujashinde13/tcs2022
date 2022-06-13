package com.bean;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


public class PensionerInput {

	private long aadharnumber;
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
	public String getPensiontype() {
		return pensiontype;
	}
	public void setPensiontype(String pensiontype) {
		this.pensiontype = pensiontype;
	}
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofbirth;
	private String pan;
	private String pensiontype;
	
	
	

}
