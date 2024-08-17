import java.util.HashMap;
import java.util.Map;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(Account targetAccount, double amount) {
        if (withdraw(amount)) {
            targetAccount.deposit(amount);
            return true;
        }
        return false;
    }
}

class BankY {
    private Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(String accountNumber, String accountHolder) {
        Account account = new Account(accountNumber, accountHolder);
        accounts.put(accountNumber, account);
        return account;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean deleteAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            return true;
        }
        return false;
    }
}

class Banky {
    public static void main(String[] args) {
        BankY bank = new BankY();

        Account account1 = bank.createAccount("001", "Alice");
        Account account2 = bank.createAccount("002", "Bob");

        account1.deposit(1000);
        account1.withdraw(200);
        account1.transfer(account2, 300);

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        bank.deleteAccount("001");
    }
}

