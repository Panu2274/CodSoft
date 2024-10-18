package Task3;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0; 
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited: %.2f\n", amount);
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew: %.2f\n", amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\n1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void handleTransactions() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    System.out.print("Do you want to display remaining balance(y/n):");
                    if((scanner.next()).equalsIgnoreCase("y")) {
                    	System.out.printf("Your current balance is: %.2f\n", account.checkBalance());
                    }
                    break;
                case 2: 
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.print("Do you want to display remaining balance(y/n):");
                    if((scanner.next()).equalsIgnoreCase("y")) {
                    	System.out.printf("Your current balance is: %.2f\n", account.checkBalance());
                    }
                    break;
                case 3: 
                    double balance = account.checkBalance();
                    System.out.printf("Your current balance is: %.2f\n", balance);
                    break;
                case 4: 
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
            
            System.out.println();
        }
        scanner.close();
    }
}

public class ATMSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** Welcome to the ATM ***");
        
        String correctAtmNumber = "123456";
        String correctPin = "2024";
        int attempts = 3; 
        
        boolean accessGranted = false;

        while (attempts > 0) {
            System.out.print("\nEnter ATM Number: ");
            String atmNumber = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            if (atmNumber.equals(correctAtmNumber) && pin.equals(correctPin)) {
                accessGranted = true;
                break; 
            } else {
                attempts--;
                System.out.println("\nInvalid ATM number or PIN. Access denied.\nAttempts remaining: " + attempts);
            }
        }

        if (accessGranted) {
            BankAccount userAccount = new BankAccount(1000.0); 
            ATM atm = new ATM(userAccount);
            atm.handleTransactions();
        } else {
            System.out.println("Too many failed attempts. Access denied.");
        }

        scanner.close();
    }
}
