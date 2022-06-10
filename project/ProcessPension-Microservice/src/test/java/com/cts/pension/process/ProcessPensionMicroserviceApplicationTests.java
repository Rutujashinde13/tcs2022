package com.cts.pension.process;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pension.process.model.PensionDetail;
import com.cts.pension.process.model.PensionerDetail;
import com.cts.pension.process.model.PensionerInput;
import com.cts.pension.process.model.ProcessPensionInput;
import com.cts.pension.process.model.ProcessPensionResponse;

import nl.jqno.equalsverifier.EqualsVerifier;
@SpringBootTest
class ProcessPensionMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void main()
	{
		ProcessPensionMicroserviceApplication.main(new String[] {});
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
		PensionerDetail pensionerDetail = new PensionerDetail(420559429030l,"rutuja",LocalDate.of(1999,12, 03),"BSDPS1495K",29000,1200,"self","SBI","9029486523","private");
		//long aadharnumber, String name, LocalDate dateofbirth, String pan, double salaryearned,
		//double allowances, String pensiontype, String bankname, String accountnumber, String banktype
		
		
		pensionerDetail.setAadharnumber(420559429030l);
		pensionerDetail.setName("rutuja");
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
		PensionerDetail pensionerDetail1 =  new PensionerDetail(420559429030l,"rutuja",LocalDate.of(1999,12, 03),"BSDPS1495K",29000,1200,"self","SBI","9029486523","private");
        PensionerDetail pensionerDetail2 = new PensionerDetail(420559429030l,"priya",LocalDate.of(1999,12, 03),"BSDPS1495K",29000,1200,"self","SBI","9029486523","private");
		
	  assertThat(assertThat(pensionerDetail1).isEqualTo(pensionerDetail2));
	
	}
	
	@Test
	void testNotEqualAndHashCode()
	{
		PensionerDetail pensionerDetail1 = new PensionerDetail(420559429030l,"shruti",LocalDate.of(1999,12, 03),"BSDPS1495K",29000,1200,"self","SBI","9029486523","private");
		PensionerDetail pensionerDetail2 = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		
			assertThat(assertThat(pensionerDetail1).isNotEqualTo(pensionerDetail2));
	
	}
	//@Test
	//void testNoArgs()
	//{
		//assertThat(new PensionerDetail()).isNotNull();
	//}
	
	

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
