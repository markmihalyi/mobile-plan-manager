package app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.tariffs.MobiNetTariff;

public class MobiNetTariffTest {
	Customer c;
	MobiNetTariff t;
	
	@Before
	public void init() {
		c = new Customer("John", "Doe", "1111 Petofi utca 1", "06307898082", "MobiNet");
		c.setSmsCount(25);
		c.setCallMinutes(50);
		t = new MobiNetTariff(40, 60, 5); // 40 = smsdíj; 60 = percdíj; 5 = ingyen sms-ek száma
	}
	
	@Test
	public void testMonthlyCost() {
		int goodResult1 = 20 * 40 + 50 * 60;
		assertEquals("get monthly cost with 25 sms", t.getMonthlyCost(c), goodResult1);
		
		c.setSmsCount(0);
		int goodResult2 = 50 * 60;
		assertEquals("get monthly cost with 0 sms", t.getMonthlyCost(c), goodResult2);
	}
}
