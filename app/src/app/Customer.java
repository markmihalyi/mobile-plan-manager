package app;

public class Customer {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber; // unique identifier
    private String tariffName;
    private int smsCount = 0;
    private int callMinutes = 0;
    
    public String getFirstName() {
    	return firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public String getAddress() {
    	return address;
    }
    
    public String getPhoneNumber() {
    	return phoneNumber;
    }
    
    public String getTariffName() {
    	return tariffName;
    }
    
    public int getSmsCount() {
    	return smsCount;
    }
    
    public int getCallMinutes() {
    	return callMinutes;
    }
    
    public void setSmsCount(int newSmsCount) {
    	smsCount = newSmsCount;
    }
    
    public void setCallMinutes(int newCallMinutes) {
    	callMinutes = newCallMinutes;
    }
    
    public String toString() {
    	return String.join(";", phoneNumber, lastName, firstName, address, tariffName);
    }

    public Customer(String firstName, String lastName, String address, String phoneNumber, String tariffName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.tariffName = tariffName;
    }
}
