package com.demo.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.PensionDetail;
import com.demo.bean.PensionerDetail;
import com.demo.bean.PensionerInput;
import com.demo.bean.ProcessPensionInput;
import com.demo.bean.ProcessPensionResponse;
import com.demo.service.ProcessPensionService;
import com.expection.AadharNumberNotFound;
import com.expection.AuthorizationException;
import com.expection.PensionerDetailException;
import com.freign.PensionDisbursementFeignClient;
import com.freign.PensionerDetailFeignClient;


@Service
public class PensionerServviceImpl implements ProcessPensionService {

	@Autowired
	private PensionerDetailFeignClient pensionerDeatailFeignClient;
	
	@Autowired
	private PensionDisbursementFeignClient pensionDisbursementFeignClient;
	
	@Override
	public PensionDetail CalculatePension(String token,PensionerInput pensionerInput) throws PensionerDetailException, AuthorizationException, AadharNumberNotFound
	
	{
		
		System.out.println("Adddhaaaaaaaaaaaar"+pensionerInput.getAadharnumber());
		
		PensionerDetail pensionerDetail = null;
		//PensionerDetail pensionerDetail = null;
		
		try
		{
			pensionerDetail = pensionerDeatailFeignClient.getPensionerDetailByAadhaar(token, pensionerInput.getAadharnumber());
			//pensionerDetail = pensionerDeatailFeignClient.(token, pensionerInput.getAadharnumber());
			System.out.println("pensionerDetail"+pensionerDetail);
		}
		catch (AadharNumberNotFound e) {
			throw new AadharNumberNotFound("Aadhar Card Number is not Valid. Please check it and try again");
		}
		
		
		if(pensionerInput.getAadharnumber() == pensionerDetail.getAadharnumber() && pensionerInput.getName().equalsIgnoreCase(pensionerDetail.getName()) && pensionerInput.getPan().equalsIgnoreCase(pensionerDetail.getPan()))
		{
			
			double salary = pensionerDetail.getSalaryearned();
			double allowances = pensionerDetail.getAllowances();
			double pensionAmount = 0;
			if(pensionerInput.getPensiontype().equalsIgnoreCase("self"))
			{
				pensionAmount = 0.8*salary + allowances;
			}
			else if(pensionerInput.getPensiontype().equalsIgnoreCase("family"))
			{
				pensionAmount = 0.5 * salary + allowances;
			}
			
			PensionDetail pensionDetail = new PensionDetail(token, null, token, token, pensionAmount);
			pensionDetail.setName(pensionerDetail.getName());
			pensionDetail.setDateofbirth(pensionerDetail.getDateofbirth());
			pensionDetail.setPan(pensionerDetail.getPan());
			pensionDetail.setPensionamount(pensionAmount);
			pensionDetail.setPensiontype(pensionerDetail.getPensiontype());
			
			return pensionDetail;
		}
		else
		{
			throw new PensionerDetailException("Invalid pensioner detail provided, please provide valid detail.");
		}
		
	}
	
	@Override
	public ProcessPensionResponse getCode(String token,ProcessPensionInput processPensionInput) throws AuthorizationException, AadharNumberNotFound
	{	try
		{
		return pensionDisbursementFeignClient.getResponse(token, processPensionInput);
		}
	
		catch(AadharNumberNotFound e)
		{
			throw new AadharNumberNotFound("Aadhar Card Number is not Valid. Please check it and try again");
		}
		 
	
		 
	}
	
	
}