package app;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Data.init();

        try {
            while (true) {
                Menu.printOptions();

                if (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    continue;
                }

                switch (scanner.nextInt()) {
                    case 0:
                        return;
                    case 1:
                        Menu.addNewCustomer();
                        break;
                    case 2:
                        Menu.modifyCustomer();
                        break;
                    case 3:
                        Menu.deleteCustomer();
                        break;
                    case 4:
                        Menu.modifyMonthlyUsage();
                        break;
                    case 5:
                        Menu.listCustomerCosts();
                        break;
                    default:
                        break;
                }
            }
        } finally {
            scanner.close();
        }
    }
}