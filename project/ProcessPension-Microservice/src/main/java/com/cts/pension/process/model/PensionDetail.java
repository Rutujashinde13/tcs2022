package com.cts.pension.process.model;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PensionDetail {

	
	private String name;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dateofbirth;
	private String pan;
	private String pensiontype;
	private double pensionamount;
	
	
	
	public PensionDetail(String name, LocalDate dateofbirth, String pan, String pensiontype, double pensionamount) {
		super();
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.pan = pan;
		this.pensiontype = pensiontype;
		this.pensionamount = pensionamount;
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
	public double getPensionamount() {
		return pensionamount;
	}
	public void setPensionamount(double pensionamount) {
		this.pensionamount = pensionamount;
	}
	
}
