package app;

public class Menu {
    public static void printOptions() {
        clearConsole();

        System.out.println("-----------------------------------");
        System.out.println("1 - Uj ugyfel letrehozasa");
        System.out.println("2 - Meglevo ugyfel modositasa");
        System.out.println("3 - Meglevo ugyfel torlese");
        System.out.println("4 - Forgalom utolagos szabalyozasa");
        System.out.println("5 - Ugyfelek koltsegeinek listazasa\n");
        System.out.println("0 - Program bezarasa");
        System.out.println("-----------------------------------");
    }

    // 1 - Add new customer
    public static void addNewCustomer() {
        clearConsole();

        // Clear scanner buffer
        Main.scanner.nextLine();

        // Last name
        System.out.print("Ugyfel vezetekneve: ");
        String lastName = Main.scanner.nextLine();
        if (lastName == "")
            return;

        // First name
        System.out.print("Ugyfel keresztneve: ");
        String firstName = Main.scanner.nextLine();
        if (firstName == "")
            return;

        // Address
        System.out.print("Ugyfel lakcime: ");
        String address = Main.scanner.nextLine();
        if (address == "")
            return;

        // Phone number
        String phoneNumber;

        while (true) {
            System.out.print("Ugyfel telefonszama: ");
            phoneNumber = Main.scanner.nextLine();
            if (phoneNumber == "")
                return;

            // Check if phone number is available
            if (Data.phoneNumberAvailable(phoneNumber)) {
                break;
            }

            System.out.println("Ez a telefonszam mar foglalt.\n");

        }

        // Tariff plan
        String tariffName;

        while (true) {
            System.out.print("Ugyfel dijcsomaga: ");
            tariffName = Main.scanner.nextLine();
            if (tariffName == "")
                return;

            // Check if tariff plan exists
            if (Data.tariffExists(tariffName)) {
                break;
            }

            System.out.println("Nem letezik ilyen dijcsomag.\n");
        }

        Customer c = new Customer(firstName, lastName, address, phoneNumber, tariffName);
        Data.addNewCustomer(c);
    }

    // 2 - Modify customer
    public static void modifyCustomer() {
        clearConsole();

        // Clear scanner buffer
        Main.scanner.nextLine();

        // Get phone number to identify the customer
        String phoneNumber;

        while (true) {
            System.out.print("Modositando ugyfel telefonszama: ");
            phoneNumber = Main.scanner.nextLine();
            if (phoneNumber == "")
                return;

            // Check if phone number exists
            if (!Data.phoneNumberAvailable(phoneNumber)) {
                break;
            }

            System.out.println("Ehhez a telefonszamhoz nem tartozik elofizeto.\n");
        }

        // Last name
        System.out.print("\nUgyfel uj vezetekneve: ");
        String lastName = Main.scanner.nextLine();
        if (lastName == "")
            return;

        // First name
        System.out.print("Ugyfel uj keresztneve: ");
        String firstName = Main.scanner.nextLine();
        if (firstName == "")
            return;

        // Address
        System.out.print("Ugyfel uj lakcime: ");
        String address = Main.scanner.nextLine();
        if (address == "")
            return;

        // Tariff plan
        String tariffName;

        while (true) {
            System.out.print("Ugyfel uj dijcsomaga: ");
            tariffName = Main.scanner.nextLine();
            if (tariffName == "")
                return;

            // Check if tariff plan exists
            if (Data.tariffExists(tariffName)) {
                break;
            }

            System.out.println("Nem letezik ilyen dijcsomag.\n");
        }

        Customer newCustomerData = new Customer(firstName, lastName, address, phoneNumber, tariffName);
        Data.modifyCustomer(newCustomerData);
    }

    // 3 - Delete customer
    public static void deleteCustomer() {
        clearConsole();

        // Clear scanner buffer
        Main.scanner.nextLine();

        // Get phone number to identify the customer
        String phoneNumber;

        while (true) {
            System.out.print("Torolni kivant ugyfel telefonszama: ");
            phoneNumber = Main.scanner.nextLine();
            if (phoneNumber == "")
                return;

            // Check if phone number exists
            if (!Data.phoneNumberAvailable(phoneNumber)) {
                break;
            }

            System.out.println("Ehhez a telefonszamhoz nem tartozik elofizeto.\n");
        }

        Data.deleteCustomer(phoneNumber);
    }

    // 4 - Modify monthly usage
    public static void modifyMonthlyUsage() {
        clearConsole();

        // Clear scanner buffer
        Main.scanner.nextLine();

        // Get phone number to identify the customer
        String phoneNumber;

        while (true) {
            System.out.print("Modositando ugyfel telefonszama: ");
            phoneNumber = Main.scanner.nextLine();
            if (phoneNumber == "")
                return;

            // Check if phone number exists
            if (!Data.phoneNumberAvailable(phoneNumber)) {
                break;
            }

            System.out.println("Ehhez a telefonszamhoz nem tartozik elofizeto.\n");
        }

        // Print current monthly usage
        Data.printMonthlyUsage(phoneNumber);

        // New sms count
        int newSmsCount;

        while (true) {
            try {
                System.out.print("\nUj kuldott SMS-ek szama: ");
                String newSmsCountStr = Main.scanner.nextLine();
                if (newSmsCountStr == "")
                    return;

                newSmsCount = Integer.parseInt(newSmsCountStr);
                break;
            } catch (Exception e) {
                System.out.println("Ervenytelen mennyiseget adtal meg.");
                continue;
            }
        }

        // New call minutes
        int newCallMinutes;

        while (true) {
            try {
                System.out.print("\nUj lebeszelt percek szama: ");
                String newCallMinutesStr = Main.scanner.nextLine();
                if (newCallMinutesStr == "")
                    return;

                newCallMinutes = Integer.parseInt(newCallMinutesStr);
                break;
            } catch (Exception e) {
                System.out.println("Ervenytelen mennyiseget adtal meg.");
                continue;
            }
        }

        Data.modifyMonthlyUsage(phoneNumber, newSmsCount, newCallMinutes);
    }

    public static void listCustomerCosts() {
        clearConsole();

        // Clear scanner buffer
        Main.scanner.nextLine();

        // List all customer's costs
        System.out.println("--------------------------------");
        Data.listCustomerCosts();
        System.out.println("--------------------------------");

        System.out.println("\nA visszalepeshez nyomj ENTER-t.");

        // Wait for any input before going back to the menu
        Main.scanner.nextLine();
    }
    
    private static void clearConsole() {
    	for(int i = 0; i < 50; i++)
    	{
    	    System.out.println("");
    	}
    }
}
