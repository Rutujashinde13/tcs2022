package com.freign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.demo.bean.PensionDetail;
import com.demo.bean.PensionerDetail;
import com.expection.AadharNumberNotFound;
import com.expection.AuthorizationException;

import io.swagger.annotations.ApiParam;

@FeignClient(name ="PensionerDetail-Microservice",url = "http://localhost:8200/pensioner/api/v1")
public interface PensionerDetailFeignClient {
	//
	
	

	@GetMapping("/PensionerDetailByAadhaar/{aadharNumber}")
	public PensionerDetail getPensionerDetailByAadhaar(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@ApiParam(name = "aadharNumber", value = "Aadhar Card Number") 
			@PathVariable long aadharNumber) throws AuthorizationException, AadharNumberNotFound;
	

}