import java.util.Scanner;

public class Account {
    // Class Variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    // Class constructor
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    // Function for depositing money
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println(previousTransaction + " has been deposited");
        } else if (previousTransaction < 0) {
            System.out.println(previousTransaction + " has been withdrawn");
        } else
            System.out.println("No transaction occured");
    }

    void getInterest(int years) {
        if (balance != 0) {
            double interestRate = 0.0185;
            double newBalance = (balance * interestRate * years);
            System.out.println("Current interest rate of " + (interestRate * 100) + "%");
            System.out.println("After " + years + " years, your balance will be " + (newBalance + balance) + ".");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A.  Check your balance");
        System.out.println("B.  Make a deposit");
        System.out.println("C.  Make a withdrawal");
        System.out.println("D.  View previous transaction");
        System.out.println("E.  Calculate interest");
        System.out.println("F.  Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: 'A', 'B', 'C', 'D', 'E', or 'F'");

            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);

            switch (option) {
                // Case 'A' allows the client to check you account balance
                case 'A':
                    System.out.println("===========================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("===========================");
                    break;

                // Case 'B allows the client to deposit money into their account
                case 'B':
                    System.out.println("===========================");
                    System.out.println("Enter an amount to deposit");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                // Case 'C' allows the client to withdraw money from their account
                case 'C':
                    System.out.println("===========================");
                    System.out.println("Enter an amount to withdraw");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                // Case 'D' allows the client to view their previous transaction
                case 'D':
                    System.out.println("===========================");
                    getPreviousTransaction();
                    System.out.println("===========================");
                    System.out.println();
                    break;

                //Case 'E' Allows the client to calculate their interest rate
                case 'E':
                    System.out.println("===========================");
                    System.out.println("Enter the amount of years");
                    int years = scanner.nextInt();
                    getInterest(years);
                    break;

                // Case 'F' allows the client to exit the portal
                case 'F':
                    System.out.println("===========================");
                    break;

                //Default case if a user enters an invalid character
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, or F");
                    break;

            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }

}