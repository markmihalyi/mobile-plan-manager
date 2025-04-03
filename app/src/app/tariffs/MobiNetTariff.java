package app.tariffs;

import app.Customer;

public class MobiNetTariff extends Tariff {
    private int freeSmsCount;

    public MobiNetTariff(int smsRate, int minuteRate, int freeSmsCount) {
        super("MobiNet", smsRate, minuteRate);
        this.freeSmsCount = freeSmsCount;
    }

    public int getMonthlyCost(Customer c) {
        return Math.max(c.getSmsCount() - freeSmsCount, 0) * smsRate + c.getCallMinutes() * minuteRate;
    }
}
