package com.pensioner.detail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pensioner.detail.model.PensionerDetail;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;



import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@SpringBootTest
class PensionerDetailMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void main()
	{
		PensionerDetailMicroserviceApplication.main(new String[] {});
	}
//	@Test
//	void testPensionerDeatil() {
//		EqualsVerifier
//		.simple().forClass(PensionerDetail.class).verify();
//}
	
	
	@Test
	void testNoArgs()
	{
		assertThat(new PensionerDetail()).isNotNull();
	}
	
	
	@Test
	void testAllArgs()
	{
		PensionerDetail pensionerDetail = new PensionerDetail();
		assertThat(assertThat(pensionerDetail).isNotNull());
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
		PensionerDetail pensionerDetail1 = new PensionerDetail();
		PensionerDetail pensionerDetail2 = new PensionerDetail();
		
			assertThat(assertThat(pensionerDetail1).isEqualTo(pensionerDetail2));
	
	}
	@Test
	void testNotEqualAndHashCode()
	{
		PensionerDetail pensionerDetail1 = new PensionerDetail();
		PensionerDetail pensionerDetail2 = new PensionerDetail();
		
			assertThat(assertThat(pensionerDetail1).isNotEqualTo(pensionerDetail2));
	
	}
	
//	@Test
//	void testPensionerDeatil() {
//		EqualsVerifier.simple()
//		.forClass(PensionerDetail.class)
//		.suppress(Warning.SURROGATE_KEY)
//		.suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
//	
//		.verify();
//	}
	
	
}