package com.cts.pension.process.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
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