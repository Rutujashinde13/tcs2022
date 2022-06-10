package com.cts.pension.disbursement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pension.disbursement.exception.AadharNumberNotFound;
import com.cts.pension.disbursement.exception.AuthorizationException;
import com.cts.pension.disbursement.feignclient.PensionDisbursementFeignClient;
import com.cts.pension.disbursement.model.PensionerDetail;
import com.cts.pension.disbursement.model.ProcessPensionInput;
import com.cts.pension.disbursement.model.ProcessPensionResponse;

@SpringBootTest
public class PensionDisbursementServiceTest {

	@InjectMocks
	private PensionDisbursementServiceImpl pensionDisbursementServiceImpl;
	
	@Mock
	private PensionDisbursementFeignClient pensionDisbursementFeignClient;
	
	@Test
	public void testGetResponcePrivate10() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		PensionerDetail pensionerDetail = new PensionerDetail();
		Mockito.when(pensionDisbursementFeignClient.getPensionerDetailByAadhaar(token, 420559429029l)).thenReturn(pensionerDetail);
		ProcessPensionInput processPensionInput = new ProcessPensionInput();
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		((ProcessPensionResponse) processPensionResponse).setProcesspensionstatuscode(10);
		assertEquals(pensionDisbursementServiceImpl.getResponce(token, processPensionInput),processPensionResponse) ;
	}
	
	@Test
	public void testGetResponcePrivate21() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		PensionerDetail pensionerDetail = new PensionerDetail();
		Mockito.when(pensionDisbursementFeignClient.getPensionerDetailByAadhaar(token, 420559429029l)).thenReturn(pensionerDetail);
		
		ProcessPensionInput processPensionInput = new ProcessPensionInput();
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcesspensionstatuscode(21);
		assertEquals(pensionDisbursementServiceImpl.getResponce(token, processPensionInput),processPensionResponse) ;
	}
	
	
	
	
}
