package app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.tariffs.SMSMaxTariff;

public class SMSMaxTariffTest {
	Customer c;
	SMSMaxTariff t;
	
	@Before
	public void init() {
		c = new Customer("John", "Doe", "1111 Petofi utca 1", "06307898082", "SMSMax");
		c.setSmsCount(25);
		c.setCallMinutes(50);
		t = new SMSMaxTariff(40, 60); // 40 = smsdíj; 60 = percdíj
	}
	
	@Test
	public void testMonthlyCost() {
		int goodResult = 25 * 40 + 50 * 60;
		assertEquals("get monthly cost", t.getMonthlyCost(c), goodResult);
	}
}
