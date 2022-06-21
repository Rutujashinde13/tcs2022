package com.processPension.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model class for process pension response
 * 
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProcessPensionResponse {

	@ApiModelProperty(value = "Status code after processing pension. 10 for success and 21 for failure")
	private int processPensionStatusCode;


	public ProcessPensionResponse(int processPensionStatusCode) {
		super();
		this.processPensionStatusCode = processPensionStatusCode;
	}

	public ProcessPensionResponse() {
		// TODO Auto-generated constructor stub
	}

	public int getProcessPensionStatusCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setProcessPensionStatusCode(int i) {
		// TODO Auto-generated method stub
		
	}

}
