package app.tariffs;

import app.Customer;

public class SMSMaxTariff extends Tariff {
    public SMSMaxTariff(int smsRate, int minuteRate) {
        super("SMSMax", smsRate, minuteRate);
    }

    public int getMonthlyCost(Customer c) {
        return c.getSmsCount() * smsRate + c.getCallMinutes() * minuteRate;
    }
}
