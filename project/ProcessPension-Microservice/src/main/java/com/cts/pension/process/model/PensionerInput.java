package com.cts.pension.process.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
@Data
@EqualsAndHashCode
public class PensionerInput {

	private long aadharnumber;
	private String name;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dateofbirth;
	private String pan;
	private String pensiontype;
	
	// creted constuctor ProcessPensionControllerMethodTest
	public PensionerInput(long laadharnumber, String string, LocalDate localDate, String string2, String string3) {
		super();
		this.aadharnumber = aadharnumber;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.pan = pan;
		this.pensiontype = pensiontype;
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
	public String getPensiontype() {
		return pensiontype;
	}
	public void setPensiontype(String pensiontype) {
		this.pensiontype = pensiontype;
	}
	
	 

	
	

}
