package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IO {
    public static ArrayList<Customer> getCustomersFromFile() {
        ArrayList<Customer> customers = new ArrayList<Customer>();

        File f = new File("src/app/data/customers.txt");

        try {
            Scanner fileScanner = new Scanner(f);

            // Ignore first two lines
            fileScanner.nextLine();
            fileScanner.nextLine();

            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(";");
                if (data.length != 5 || !Data.tariffExists(data[4]))
                    continue;

                Customer c = new Customer(data[2], data[1], data[3], data[0], data[4]);
                customers.add(c);
            }

            fileScanner.close();
        } catch (FileNotFoundException fe) {
            return customers;
        }
       
        return customers;
    }

    public static void saveCustomersToFile(ArrayList<Customer> customers) {
        try {
            FileWriter fw = new FileWriter("src/app/data/customers.txt");
            
            fw.write("TELEFONSZAM;VEZETEKNEV;KERESZTNEV;LAKCIM;DIJCSOMAG\n");
            fw.write("--------------------------------------------------\n");

            for (Customer c : customers) {
                fw.write(c + "\n");
            }

            fw.close();
        } catch (IOException e) {
        	System.out.println(e.getMessage());
            System.out.println("IO hiba tortent. Ellenorizd a program jogosultsagait.");
            System.exit(0);
        }
    }

    public static void loadMonthlyUsageFromFile() {
        File f = new File("src/app/data/monthly_usage.txt");

        try {
            Scanner fileScanner = new Scanner(f);

            // Ignore first two lines
            fileScanner.nextLine();
            fileScanner.nextLine();

            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(";");
                if (data.length != 3 || Data.phoneNumberAvailable(data[0]))
                    continue;

                int smsCount = Integer.parseInt(data[1]);
                int callMinutes = Integer.parseInt(data[2]);
                Data.loadMonthlyUsage(data[0], smsCount, callMinutes);
            }

            fileScanner.close();
        } catch (FileNotFoundException fe) {
            return;
        }
    }

    public static void saveMonthlyUsageToFile(ArrayList<Customer> customers) {
        try {
            FileWriter fw = new FileWriter("src/app/data/monthly_usage.txt");
            
            fw.write("TELEFONSZAM;KULDOTT SMSEK;LEBESZELT PERCEK\n");
            fw.write("------------------------------------------\n");

            for (Customer c : customers) {
                String smsCountStr = String.valueOf(c.getSmsCount());
                String callMinutesStr = String.valueOf(c.getCallMinutes());
                String line = String.join(";", c.getPhoneNumber(), smsCountStr, callMinutesStr);
                fw.write(line + "\n");
            }

            fw.close();
        } catch (IOException e) {
            System.out.println("IO hiba tortent. Ellenorizd a program jogosultsagait.");
            System.exit(0);
        }
    }

}
