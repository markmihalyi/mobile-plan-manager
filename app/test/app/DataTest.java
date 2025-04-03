package app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTest {
    @Before
    public void init() {
    	Data.init();
        Data.addNewCustomer(new Customer("Anna", "Kovács", "Kossuth tér 1", "06305438012", "Alap"));
        Data.addNewCustomer(new Customer("Péter", "Nagy", "Deák tér 5", "06306598094", "MobiNet"));
    }
    
    @Test
    public void testGetCustomer() {
    	String phoneNumber1 = "06305438012";
    	Customer c1 = Data.getCustomer(phoneNumber1);
    	assertEquals("get existing customer", c1.getPhoneNumber(), phoneNumber1);
    	
    	String phoneNumber2 = "06305009000";
    	Customer c2 = Data.getCustomer(phoneNumber2);
    	assertTrue("get non-existant customer", c2 == null);
    }
    
    @Test
    public void testAddNewCustomer() {
        Data.addNewCustomer(new Customer("Eszter", "Tóth", "Petőfi Sándor utca 10", "06304779450", "SMSMax"));
        assertTrue("add new customer", Data.getCustomer("06304779450") != null);
    }
    
    @Test
    public void testModifyCustomer() {
    	String phoneNumber = "06305438012";
    	String newAddress = "Kossuth tér 10";
    	String newTariffName = "SMSMax";
    	Customer newCustomerData = new Customer("Anna", "Kovács", newAddress, phoneNumber, newTariffName);
    	Data.modifyCustomer(newCustomerData);
    	
    	Customer c = Data.getCustomer(phoneNumber);
    	assertEquals("customer's address modified", c.getAddress(), newAddress);
    	assertEquals("customer's tariff modified", c.getTariffName(), newTariffName);
    }
    
    @Test
    public void testDeleteCustomer() {
    	Data.deleteCustomer("06306598094");
    	assertTrue("delete customer", Data.getCustomer("06306598094") == null);
    }
    
    
    @Test
    public void testPhoneNumberAvailable() {
    	String phoneNumber1 = "06305009000";
    	assertTrue("phone number available", Data.phoneNumberAvailable(phoneNumber1));
    	
    	String phoneNumber2 = "06305438012";
    	assertFalse("phone number not available", Data.phoneNumberAvailable(phoneNumber2));
    }
    
    @Test
    public void testTariffExists() {
    	String tariffName1 = "Alap";
    	assertTrue("tariff exists", Data.tariffExists(tariffName1));
    	
    	String tariffName2 = "SzuperMax";
    	assertFalse("tariff not exists", Data.tariffExists(tariffName2));
    }
    
    @Test
    public void testLoadMonthlyUsage() {
    	String phoneNumber = "06305555555";
        Data.addNewCustomer(new Customer("Ubul", "Péter", "Vörösmarty utca 3", phoneNumber, "Alap"));
        Data.loadMonthlyUsage(phoneNumber, 100, 200);
    	
    	Customer c = Data.getCustomer(phoneNumber);
    	assertEquals("load monthly sms count", c.getSmsCount(), 100);
    	assertEquals("load monthly call minutes", c.getCallMinutes(), 200);
    }
    
    @After
    public void end() {
    	Data.deleteCustomer("06305438012"); // init
    	Data.deleteCustomer("06306598094"); // init
    	Data.deleteCustomer("06304779450"); // testAddNewCustomer
    	Data.deleteCustomer("06305555555"); // testLoadMonthlyUsage
    }
   
}
