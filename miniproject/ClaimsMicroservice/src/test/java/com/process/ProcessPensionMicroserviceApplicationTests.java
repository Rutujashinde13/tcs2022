package com.process;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.ClaimsMicroserviceApplication;
import com.demo.bean.PensionDetail;
import com.demo.bean.PensionerDetail;
import com.demo.bean.PensionerInput;
import com.demo.bean.ProcessPensionInput;
import com.demo.bean.ProcessPensionResponse;

import nl.jqno.equalsverifier.EqualsVerifier;
@SpringBootTest(classes = ClaimsMicroserviceApplication.class)
class ProcessPensionMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void main()
	{
		ProcessPensionMicroserviceApplicationTests.main(new String[] {});
	}
	
	private static void main(String[] strings) {
		// TODO Auto-generated method stub
		
	}

	@Test
	void testPensionerDeatil() {
		EqualsVerifier.simple().forClass(PensionerDetail.class).verify();
	}
	
	@Test
	void testPensionDetail() {
		EqualsVerifier.simple().forClass(PensionDetail.class).verify();
	}
	
	@Test
	void testPensionerInputDeatils() {
		EqualsVerifier.simple().forClass(PensionerInput.class).verify();
	}
	
	@Test
	void testProcessPensionerInput() {
		EqualsVerifier.simple().forClass(ProcessPensionInput.class).verify();
	}
	@Test
	void testProcessPensionResponseDeatils() {
		EqualsVerifier.simple().forClass(ProcessPensionResponse.class).verify();
	}
	
	@Test
	void testSetterMethod()
	{
		PensionerDetail pensionerDetail = new PensionerDetail();
		pensionerDetail.setAadharnumber(420559429029l);
		pensionerDetail.setName("Parthik");
		pensionerDetail.setDateofbirth(LocalDate.of(1999, 12, 03));
		pensionerDetail.setPan("BSDPS1495K");
		pensionerDetail.setSalaryearned(29000);
		pensionerDetail.setAllowances(1200);
		pensionerDetail.setPensiontype("self");
		pensionerDetail.setBankname("SBI");
		pensionerDetail.setAccountnumber("9029486523");
		pensionerDetail.setBanktype("private");
		
		assertThat(assertThat(pensionerDetail).isNotNull());
	}
	
	@Test
	void testEqualAndHashCode()
	{
		PensionerDetail pensionerDetail1 = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		PensionerDetail pensionerDetail2 = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		
			assertThat(assertThat(pensionerDetail1).isEqualTo(pensionerDetail2));
	
	}
	@Test
	void testNotEqualAndHashCode()
	{
		PensionerDetail pensionerDetail1 = new PensionerDetail(420559429030l, "Shubhm", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		PensionerDetail pensionerDetail2 = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		
			assertThat(assertThat(pensionerDetail1).isNotEqualTo(pensionerDetail2));
	
	}
	
	
	
	@Test
	void testProcessPensionResponce()
	{
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcesspensionstatuscode(10);
		assertThat(assertThat(processPensionResponse).isNotNull());
	}
	@Test
	void testProcessPensionResponceNoArgs()
	{
		assertThat(new ProcessPensionResponse()).isNotNull();
	}
	
}