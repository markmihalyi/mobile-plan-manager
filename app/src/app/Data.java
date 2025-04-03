package app;

import java.util.ArrayList;

import app.tariffs.AlapTariff;
import app.tariffs.MobiNetTariff;
import app.tariffs.SMSMaxTariff;
import app.tariffs.Tariff;

public class Data {
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    private static ArrayList<Tariff> tariffs = new ArrayList<Tariff>();

    public static void init() {
        // Initialize tariff plans
        tariffs.add(new AlapTariff(50, 75));
        tariffs.add(new MobiNetTariff(45, 60, 10));
        tariffs.add(new SMSMaxTariff(35, 70));

        // Load existing customers from file
        customers = IO.getCustomersFromFile();

        // Load monthly usage from another file
        IO.loadMonthlyUsageFromFile();
    }

    public static Customer getCustomer(String phoneNumber) {
    	for (Customer c : customers) {
    		if (c.getPhoneNumber().equals(phoneNumber)) {
    			return c;
    		}
    	}
    	return null;
    }
    
    public static boolean phoneNumberAvailable(String phoneNumber) {
    	return getCustomer(phoneNumber) == null;
    }
   
    public static boolean tariffExists(String tariffName) {
        for (Tariff t : tariffs) {
            if (t.getName().equals(tariffName)) {
                return true;
            }
        }
        return false;
    }

    public static void loadMonthlyUsage(String phoneNumber, int smsCount, int callMinutes) {
        for (Customer c : customers) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                c.setSmsCount(smsCount);
                c.setCallMinutes(callMinutes);
                break;
            }
        }
    }

    public static void addNewCustomer(Customer c) {
    	if (getCustomer(c.getPhoneNumber()) != null) return;
        customers.add(c);
        IO.saveCustomersToFile(customers);
    }

    public static void modifyCustomer(Customer newCustomerData) {
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            if (c.getPhoneNumber().equals(newCustomerData.getPhoneNumber())) {
            	newCustomerData.setSmsCount(c.getSmsCount());
            	newCustomerData.setCallMinutes(c.getCallMinutes());
                customers.set(i, newCustomerData);
                break;
            }
        }
        IO.saveCustomersToFile(customers);
    }

    public static void deleteCustomer(String phoneNumber) {
    	if (getCustomer(phoneNumber) == null) return;
    	
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(customers.size());
                customers.remove(i);
                System.out.println(customers.size());
                break;
            }
        }
        IO.saveCustomersToFile(customers);
        IO.saveMonthlyUsageToFile(customers);
    }

    public static void printMonthlyUsage(String phoneNumber) {
        for (Customer c : customers) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Kuldott SMS-ek szama: " + c.getSmsCount());
                System.out.println("Lebeszelt percek: " + c.getCallMinutes());
                break;
            }
        }
    }

    public static void modifyMonthlyUsage(String phoneNumber, int smsCount, int callMinutes) {
        loadMonthlyUsage(phoneNumber, smsCount, callMinutes);
        IO.saveMonthlyUsageToFile(customers);
    }

    public static void listCustomerCosts() {
        for (Customer c : customers) {
            for (Tariff t : tariffs) {
                if (t.getName().equals(c.getTariffName())) {
                    System.out.println(c.getPhoneNumber() + " - " + t.getMonthlyCost(c) + " HUF");
                    break;
                }
            }
        }
    }
    
    public static int getCustomerCount() {
    	return customers.size();
    }
}
