// Task-2 : BankY

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    String accountNumber;
    String accountHolderName;
    double balance;

    Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
}

public class BankY {
    Map<String, Account> accounts = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void createAccount() {
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter account holder name:");
        String accountHolderName = scanner.nextLine();
        System.out.println("Enter initial balance:");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        Account account = new Account(accountNumber, accountHolderName, balance);
        accounts.put(accountNumber, account);
    }

    public void deposit() {
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.balance += amount;
        }
    }

    public void withdraw() {
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null && account.balance >= amount) {
            account.balance -= amount;
        }
    }

    public void run() {
        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void main(String[] args) {
        BankY bank = new BankY();
        bank.run();
    }
}