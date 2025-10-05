package lesson03.BasicTasks;

import java.util.Scanner;

class BankAccount {
    private final String fio;
    private static int idCreator = 0;
    private int accountNumber = 0;
    private double balance = 0;

    BankAccount (String fio) {
        ++idCreator;
        this.accountNumber = idCreator;
        this.fio = fio;
    }

    public boolean deposit (double putting_amount) {
        if(putting_amount > 0) {
            balance += putting_amount;

            return true;
        }else{
            System.out.println();
            System.out.println("You can't deposit 0 or less USDs into the bank");

            return false;
        }
    }

    public boolean withdraw (double withdraw_amount) {
        if(withdraw_amount <= this.balance) {
            this.balance -= withdraw_amount;

            return true;
        }else{
            System.out.println();
            System.out.println("Withdrawal amount is greater than the amount of balance");

            return false;
        }
    }

    public double getBalance () {
        return this.balance;
    }

    public void showFullInfo () {
        System.out.println("Your information : ");
        System.out.println("Account number : " + this.accountNumber);
        System.out.println("Full name : " + this.fio);
        System.out.println("Balance : " + this.balance);
    }
}

class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Welcome to the BankAccount task");

        System.out.print("Please enter your full name : ");

        String fio = scanner.nextLine();

        BankAccount bankAccount = new BankAccount(fio);

        int choice = 0;

        while(choice != 5) {

            System.out.println();
            System.out.println("Actions you can do : ");
            System.out.println("1) Deposit money into the bank");
            System.out.println("2) Withdraw money from the bank ");
            System.out.println("3) Show balance");
            System.out.println("4) Show full information");
            System.out.println("5) Exit");
            System.out.print("\nChoose an action you want to execute : ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int deposit_choice = 1;
                    while(deposit_choice == 1) {
                        System.out.println();
                        System.out.print("Enter the amount you want to deposit : ");
                        double deposit_amount = scanner.nextDouble();
                        if(bankAccount.deposit(deposit_amount)){
                            System.out.println();
                            System.out.println("Deposit of " + deposit_amount +" has been made successfully");
                            break;
                        }else{
                            System.out.println();
                            System.out.println("Do you want to retry ?");
                            System.out.println("\n1) Yes");
                            System.out.println("Enter any other number to exit");
                            System.out.print("Make a choice : ");
                            deposit_choice = scanner.nextInt();
                        }
                    }
                    System.out.println("----------------------------------");
                    break;

                case 2:
                    int withdrawal_choice = 1;
                    while(withdrawal_choice == 1) {
                        System.out.println();
                        System.out.print("Enter the amount you want to withdraw : ");
                        double withdrawal_amount = scanner.nextDouble();
                        if(bankAccount.withdraw(withdrawal_amount)){
                            System.out.println();
                            System.out.println("The withdrawal of " + withdrawal_amount + " has been made successfully");
                            break;
                        }else{
                            System.out.println();
                            System.out.println("Do you want to retry ?");
                            System.out.println("\n1) Yes");
                            System.out.println("Enter any other number to exit");
                            System.out.print("Make a choice : ");
                            withdrawal_choice = scanner.nextInt();
                        }
                    }

                    System.out.println("----------------------------------");

                    break;

                case 3:
                    double balance = bankAccount.getBalance();
                    System.out.println("\nYour balance is " + balance);
                    System.out.println("----------------------------------");

                    break;
                case 4:
                    System.out.println();
                    bankAccount.showFullInfo();
                    System.out.println("----------------------------------");
                    break;
                case 5:
                    choice = 5;
                    break;

                default:
                    System.out.println();
                    System.out.println("You have chosen an incorrect option , please try again");
                    System.out.println("----------------------------------");
            }
        }
    }
}

