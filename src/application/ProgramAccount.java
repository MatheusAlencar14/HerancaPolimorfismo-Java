package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class ProgramAccount {

    public static void main(String[] args) {

        Account acc = new Account(1001, "Ana", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Miguel", 0.0, 500.0);

        // UPCasting

        Account acc1 = new BusinessAccount(1003, "Jaci", 0.0, 200.0);
        Account acc2 = new SavingsAccount(1004, "Júlia", 0.0, 0.1);
        Account acc3 = bacc;

        // DOWNCasting

        BusinessAccount acc4 = (BusinessAccount) acc1;

        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }
    }
}
