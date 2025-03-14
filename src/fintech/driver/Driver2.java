package fintech.driver;

/**
 * Author: NIM Nama
 * Author: NIM Nama
 */

import fintech.model.Account;
import fintech.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver2 {
    private static List<Account> accounts = new ArrayList<>();
    private static int transactionId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputs = scanner.nextLine();

            if (inputs.equals("---")) {
                break;
            }

            String[] parts = inputs.split("#");
            String command = parts[0];

            // Membaca input pertama (create-account)
            if (command.equals("create-account")) {
                if (parts.length == 3) {
                    String owner = parts[1];
                    String accountName = parts[2];

                    Account newAccount = new Account(owner, accountName);
                    accounts.add(newAccount);
                    System.out.println( newAccount);
                }
            }

        
            if (command.equals("create-transaction")) {
                if (parts.length == 5) {
                    String accountName = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    String postedAt = parts[3];
                    String note = parts[4];

                    Account foundAccount = findAccountByName(accountName);
                    if (foundAccount != null) {
                        if (foundAccount.getBalance() + amount >= 0) {
                            Transaction transaction = new Transaction(accountName, amount, postedAt, note);
                            foundAccount.addTransaction(transaction);
                            System.out.println( transaction);
                        } 
                    }
                }
            }
            

            
            if (command.equals("show-account")) {
                if (parts.length == 2) {
                    String accountName = parts[1];
                    Account foundAccount = findAccountByName(accountName);
                    if (foundAccount != null) {
                        System.out.println( foundAccount);
                    } else {
                        System.out.println("Account not found");
                    }
                }
            }
        }

        scanner.close();
    }

    private static Account findAccountByName(String accountName) {
        for (Account account : accounts) {
            if (account.getAccountName().equals(accountName)) {
                return account;
            }
        }
        return null;
    }
}