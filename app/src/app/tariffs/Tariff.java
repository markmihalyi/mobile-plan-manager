package app.tariffs;

import app.Customer;

public abstract class Tariff {
    private String name;
    protected int smsRate;
    protected int minuteRate;
    
    public String getName() {
    	return name;
    }
    
    public int getSmsRate() {
    	return smsRate;
    }
    
    public int getMinuteRate() {
    	return minuteRate;
    }

    public Tariff(String name, int smsRate, int minuteRate) {
        this.name = name;
        this.smsRate = smsRate;
        this.minuteRate = minuteRate;
    }

    /**
     * Kiszámítja és visszaadja egy ügyfél havi költségeit.
     * @param c (Customer példány)
     * @return int (havi költség)
     */
    public abstract int getMonthlyCost(Customer c);
}
