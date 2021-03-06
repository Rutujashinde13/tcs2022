package com.pensioner.detail.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.pensioner.detail.exception.AadharNumberNotFound;
import com.pensioner.detail.feignclient.AuthorisingClient;
import com.pensioner.detail.model.PensionerDetail;
import com.pensioner.detail.repository.PensionerDetailRepository;
import com.pensioner.detail.service.PensionerDetailServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PensionerDetailServiceTest {

	@InjectMocks
	private PensionerDetailServiceImpl pensionerDetailServiceImpl;
	
	@Mock
	private PensionerDetailRepository pensionerDetailRepository;
	
	@Mock
	private AuthorisingClient authClient;
	
	@Test
	public void testGetPensionDetailByAadharCard() throws AadharNumberNotFound
	{
		PensionerDetail pensionerDetail = new PensionerDetail();
		
		String token = "dummy";
//		Mockito.when(authClient.authorizeTheRequest(token)).thenReturn(true);
		Mockito.when(pensionerDetailRepository.findById(420559429029l)).thenReturn(Optional.of(pensionerDetail));
		assertEquals(pensionerDetailServiceImpl.getPensionerDetailByAadharCard(token,420559429029l),pensionerDetail);
	}
	
}
