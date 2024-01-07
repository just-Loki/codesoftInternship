// task 3
// ATM interface

import java.util.Scanner;

class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance)
 {
     this.balance = initialBalance;
  }

    public double getBalance()
 {
     return balance;
  }

    public void deposit(double amount) {
        balance += amount;
    }


    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return false;
        }
        balance -= amount;
        return true;
    }
}

class ATM 
{
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public void handleOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) 
     {
            case 1:
                System.out.println("Balance: RS" + userAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter withdrawal amount: RS");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: RS" + userAccount.getBalance());
                }
                break;
            case 3:
                System.out.print("Enter deposit amount: RS");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. New balance: RS" + userAccount.getBalance());
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class AtmInterface  {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance of RS1000
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            atm.handleOption(option);
        }
    }
}