package lesson03.Practice;

import lesson03.BasicTasks.BankAccount;

import java.util.ArrayList;
import java.util.Scanner;

class BankSystem{
    private int accountNumber;
    private String fio;
    private double balance;
    private static ArrayList<BankAccount> accountsCollection = new ArrayList<>();

    public void getAccountInfo (BankAccount account) {
        boolean found = false;
        for(BankAccount collections_account : accountsCollection) {
            if(collections_account.getAccountNumber() == account.getAccountNumber()){
                found = true;
                account.showFullInfo();
                break;
            }
        }

        if(!found) {
            System.out.println("There is no account like this in the collection");
        }
    }

    public void addAccount (BankAccount account) {
        this.fio = account.getFio();
        this.balance = account.getBalance();
        accountsCollection.add(account);
        System.out.println("Account added successfully");
    }

    public void deleteAccount(BankAccount account){
        boolean found = false;
        int found_index = 0;
        for(BankAccount collection_account : accountsCollection){
            if(collection_account.getAccountNumber() == account.getAccountNumber()){
                found = true;
                found_index = accountsCollection.indexOf(collection_account);
            }
        }

        if(!found) {
            System.out.println("There is no account like this in the collection");
        }else{
            accountsCollection.remove(found_index);
            System.out.println("Account has been deleted");
        }
    }

    public void replenishAccount (BankAccount account , double amount_to_deposit) {
        boolean found = false;
        for(BankAccount collection_account : accountsCollection){
            if(collection_account.getAccountNumber() == account.getAccountNumber()) {
                account.deposit(amount_to_deposit);
                found = true;
            }
        }

        if(!found){
            System.out.println("There is no account like this in the collection");
        }
    }

    public void transferMoneyBetweenAccounts (BankAccount money_giver , int recieverAccountNumber , double amount_to_tranfer) {
        int status = 0;
        int money_giver_index = 0;
        int money_reciever_index = 0;
        for(BankAccount collection_account : accountsCollection) {
            if(collection_account.getAccountNumber() == money_giver.getAccountNumber()) {
                ++status;
                money_giver_index = accountsCollection.indexOf(collection_account);
            }

            if(collection_account.getAccountNumber() == recieverAccountNumber) {
                ++status;
                money_reciever_index = accountsCollection.indexOf(collection_account);
            }

            if(status == 2) break;
        }

        if(status == 2) {
            if(amount_to_tranfer <= 0) {
                System.out.println("Minimal transfer amount is 1 USD");
            }else if(money_giver.getBalance() < amount_to_tranfer){
                System.out.println("Money sending account does not have enough funds in it");
            }else{
                accountsCollection.get(money_giver_index).withdraw(amount_to_tranfer);
                accountsCollection.get(money_reciever_index).deposit(amount_to_tranfer);
            }
        }else{
            System.out.println("There is an account that does not belong to the banking system");
        }
    }
}

class BankSystemMain {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Let's first create an account");

        System.out.print("Enter your full name (account 1) : ");
        String fio = scanner.nextLine();

        System.out.print("Enter your full name (account 2) : ");
        String fio_2 = scanner.nextLine();

        BankAccount account = new BankAccount(fio);
        BankAccount account_2 = new BankAccount(fio_2);
        BankSystem bank = new BankSystem();

        int choice = 0;

        while(choice != 6) {
            System.out.println("There are options you can do : ");
            System.out.println("1) Get account information");
            System.out.println("2) Add account");
            System.out.println("3) Delete account");
            System.out.println("4) Replenish account");
            System.out.println("5) Transfer money from your account to another one");
            System.out.println("6) Exit");
            System.out.print("Choose one of the options : ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    bank.getAccountInfo(account);
                    System.out.println();
                    bank.getAccountInfo(account_2);
                    break;
                case 2:
                    bank.addAccount(account);
                    bank.addAccount(account_2);
                    break;
                case 3:
                    bank.deleteAccount(account);
                    break;
                case 4:
                    System.out.print("Please enter an amount that you want to replenish the account with : ");
                    double amount_to_deposit = scanner.nextDouble();
                    scanner.nextLine();
                    bank.replenishAccount(account,amount_to_deposit);
                    break;
                case 5:
                    System.out.print("Enter the account number that you want to transfer your money to : ");
                    int recieving_account = scanner.nextInt();
                    System.out.print("Enter the amount you want to the account with the account number of " + recieving_account + " : ");
                    double amount_to_transfer = scanner.nextDouble();
                    scanner.nextLine();
                    bank.transferMoneyBetweenAccounts(account,recieving_account,amount_to_transfer);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("You have chosen an incorrect option");
            }
        }

    }
}