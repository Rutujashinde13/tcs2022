package com.cts.pension.disbursement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pension.disbursement.exception.AadharNumberNotFound;
import com.cts.pension.disbursement.exception.AuthorizationException;
import com.cts.pension.disbursement.feignclient.PensionDisbursementFeignClient;
import com.cts.pension.disbursement.model.PensionerDetail;
import com.cts.pension.disbursement.model.ProcessPensionInput;
import com.cts.pension.disbursement.model.ProcessPensionResponse;

@Service
public class PensionDisbursementServiceImpl implements PensionDisbursementService {
	
	@Autowired
	private PensionDisbursementFeignClient pensionDisbursementFeignClient;
	
	
	@Override
	public ProcessPensionResponse getResponce(String token,ProcessPensionInput processPensionInput) throws AuthorizationException, AadharNumberNotFound
	{
		PensionerDetail pensionerDetail = null;
		try
		{
		pensionerDetail = pensionDisbursementFeignClient.getPensionerDetailByAadhaar(token, processPensionInput.getAadharnumber());
		}
		catch(AadharNumberNotFound e)
		{
			throw new AadharNumberNotFound("Aadhar Number Not found");
			
		}
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		double serviceCharge = processPensionInput.getBankcharge();
		
		double checkAmount=0;
		if(pensionerDetail.getBankType().equalsIgnoreCase("public"))
		{
			checkAmount = 500;
		}
		else if(pensionerDetail.getBankType().equalsIgnoreCase("private"))
		{
			checkAmount = 550;
		}
		
		System.out.println("checkamounttt"+checkAmount);
		System.out.println("serviceChargee"+serviceCharge);
		
		if(checkAmount == serviceCharge)
		{
			processPensionResponse.setProcesspensionstatuscode(10);
		}
		else
		{
			processPensionResponse.setProcesspensionstatuscode(21);
		}
		
		System.out.println("processPensionResponce........."+processPensionResponse);
		return processPensionResponse;
	}

}
