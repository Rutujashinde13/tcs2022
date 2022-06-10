package com.cts.pension.disbursement.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ProcessPensionResponse {
	private int processpensionstatuscode;

	public int getProcesspensionstatuscode() {
		return processpensionstatuscode;
	}

	public void setProcesspensionstatuscode(int processpensionstatuscode) {
		this.processpensionstatuscode = processpensionstatuscode;
	}

	

}