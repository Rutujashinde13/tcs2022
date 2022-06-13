package com.foregin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.bean.PensionDetail;
import com.bean.PensionerInput;
import com.bean.ProcessPensionInput;
import com.bean.ProcessPensionResponse;
import com.expection.AadharNumberNotFound;
import com.expection.AuthorizationException;
import com.expection.PensionerDetailException;

import io.swagger.annotations.ApiOperation;



@FeignClient(name = "ProcessPension-Microservice", url = "http://localhost:8100/process/api/v1")
public interface ProcessPensionFeignClient {

	@PostMapping("/PensionDetail")
	@ApiOperation(notes = "Returns the Pension Details", value = "Find the pension details")
	public PensionDetail getPensionDetail(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody PensionerInput pensionerInput) throws AuthorizationException, PensionerDetailException, AadharNumberNotFound;
	
	
	@PostMapping("/ProcessPension")
	@ApiOperation(notes = "Returns the Process Responce Code(10 or 21)", value = "Find Process Responce Code, If Process code is 10 then Suceess and 21 means not success")
	public ProcessPensionResponse getprocessingCode(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody ProcessPensionInput processPensionInput) throws AuthorizationException, AadharNumberNotFound;
}
