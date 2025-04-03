package app.tariffs;

import app.Customer;

public class AlapTariff extends Tariff {
    public AlapTariff(int smsRate, int minuteRate) {
        super("Alap", smsRate, minuteRate);
    }

    public int getMonthlyCost(Customer c) {
        return 500 + c.getSmsCount() * smsRate + c.getCallMinutes() * minuteRate;
    }
}
