# Mobile Plan Manager

A simple command-line application for managing mobile service provider records, including customer registration, modification, deletion, and usage tracking.

## Features

- Add new customers with name, address, phone number, and plan details
- Modify existing customer details (excluding phone number)
- Delete customers by phone number
- Adjust customer usage data (SMS sent, call minutes used)
- Calculate and display customer billing based on usage
- Data is stored in a file to ensure persistence

## Usage

The program is menu-driven:

1. **Add New Customer** - Enter details to register a new user.
2. **Modify Customer** - Update details of an existing customer.
3. **Delete Customer** - Remove a customer using their phone number.
4. **Adjust Usage** - Modify the number of SMS sent and minutes used.
5. **List Customer Bills** - Display costs based on stored data.
6. **Exit** - Close the application.

Users navigate through the menu by entering the corresponding option number. To return to the main menu from submenus, press ENTER.

## File Storage

The application saves data to a file, ensuring that customer records persist across sessions.
