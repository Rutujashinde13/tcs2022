package com.freign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.expection.AadharNumberNotFound;
import com.expection.AuthorizationException;



	

@FeignClient(name = "PensionDisbursement-Microservices",url = "http://localhost:8300/disbursement/api/v1")
public interface PensionDisbursementFeignClient {
	
	@PostMapping("/disbursePension")
	public com.demo.bean.ProcessPensionResponse getResponse(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody com.demo.bean.ProcessPensionInput processpensionInput) throws AuthorizationException, AadharNumberNotFound;
	
}