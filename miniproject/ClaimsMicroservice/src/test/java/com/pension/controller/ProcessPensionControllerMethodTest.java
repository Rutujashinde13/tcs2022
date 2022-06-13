package com.pension.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.controller.ProcessPensionController;
import com.demo.bean.PensionDetail;
import com.demo.bean.PensionerInput;
import com.demo.bean.ProcessPensionInput;
import com.demo.bean.ProcessPensionResponse;
import com.demo.service.ProcessPensionService;
import com.expection.AadharNumberNotFound;
import com.expection.AuthorizationException;
import com.expection.PensionerDetailException;
import com.freign.AuthorisingClient;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProcessPensionControllerMethodTest {


	@InjectMocks
	private ProcessPensionController processPensionController;

	@MockBean
	private AuthorisingClient authorisingClient;
	
	@Mock
	private ProcessPensionService processPensionServiceImpl;
	

	

	
	@Test
	public void testControllerObjectNotNull() {
		assertNotNull(processPensionController);
	}
	
	@Test
	public void testServiceObjectNotNull() {
		assertNotNull(processPensionServiceImpl);
	}
	
	
	@Test
	public void testGetPensionDetail() throws PensionerDetailException, AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
		//PensionerInput pensionerInput = new PensionerInput(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", "self");
		PensionerInput pensionerInput = new PensionerInput();
		PensionDetail pensionDetail = new PensionDetail("Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", "self", 24560.0);
		Mockito.when(processPensionServiceImpl.CalculatePension(token, pensionerInput)).thenReturn(pensionDetail);
		assertEquals(processPensionController.getPensionDetail(token, pensionerInput), pensionDetail);
	}
	

	@Test
	public void testGetprocessingCode10() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
		ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 550);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcesspensionstatuscode(10);
		
		Mockito.when(processPensionServiceImpl.getCode(token, processPensionInput)).thenReturn(processPensionResponse);
		assertEquals(processPensionController.getprocessingCode(token, processPensionInput), processPensionResponse);
	}
	
	@Test
	public void testGetprocessingCode21() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
		ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 500);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcesspensionstatuscode(21);
		
		Mockito.when(processPensionServiceImpl.getCode(token, processPensionInput)).thenReturn(processPensionResponse);
		assertEquals(processPensionController.getprocessingCode(token, processPensionInput), processPensionResponse);
	}
	
}
