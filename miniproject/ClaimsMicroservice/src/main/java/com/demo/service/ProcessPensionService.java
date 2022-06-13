package com.demo.service;

import com.demo.bean.PensionDetail;
import com.demo.bean.PensionerInput;
import com.demo.bean.ProcessPensionInput;
import com.demo.bean.ProcessPensionResponse;
import com.expection.AadharNumberNotFound;
import com.expection.AuthorizationException;
import com.expection.PensionerDetailException;

public interface ProcessPensionService {
	
	public PensionDetail CalculatePension(String token,PensionerInput pensionerInput) throws PensionerDetailException, AuthorizationException, AadharNumberNotFound;
	public ProcessPensionResponse getCode(String token,ProcessPensionInput processPensionInput) throws AuthorizationException, AadharNumberNotFound;
}
