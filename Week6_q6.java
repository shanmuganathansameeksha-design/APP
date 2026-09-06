package accounts;

public class Account
{
    protected int accountNumber;
    protected String holderName;
    protected double balance;

    public Account(int accountNumber, String holderName, double balance)
    {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void displayDetails()
    {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: Rs." + balance);
    }
}
package accounts;

public class SavingsAccount extends Account
{
    private double interestRate;

    public SavingsAccount(int accountNumber, String holderName,
                          double balance, double interestRate)
    {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayDetails()
    {
        System.out.println("Savings Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: Rs." + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
package accounts;

public class CurrentAccount extends Account
{
    private double overdraftLimit;

    public CurrentAccount(int accountNumber, String holderName,
                          double balance, double overdraftLimit)
    {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void displayDetails()
    {
        System.out.println("Current Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: Rs." + balance);
        System.out.println("Overdraft Limit: Rs." + overdraftLimit);
    }
}
package payments;

public interface Payment
{
    void pay(double amount);
}
package payments;

public interface OnlineTransaction
{
}
package payments;

public interface SecurePayment extends Payment
{
    void verifyPayment();
}
package payments;

public class UPIPayment implements SecurePayment, OnlineTransaction
{
    public void pay(double amount)
    {
        System.out.println("Paid Rs." + amount + " using UPI");
    }

    public void verifyPayment()
    {
        System.out.println("UPI payment verified successfully");
    }
}
package payments;

public class CardPayment implements Payment, OnlineTransaction
{
    public void pay(double amount)
    {
        System.out.println("Paid Rs." + amount + " using Card");
    }
}
import accounts.Account;
import accounts.SavingsAccount;
import accounts.CurrentAccount;

import payments.Payment;
import payments.UPIPayment;
import payments.CardPayment;
import payments.SecurePayment;
import payments.OnlineTransaction;

public class Main
{
    public static void main(String[] args)
    {
        Account account;

        account = new SavingsAccount(1001, "Sameeksha", 25000, 6.5);
        account.displayDetails();

        System.out.println();

        account = new CurrentAccount(1002, "Anvitha", 40000, 10000);
        account.displayDetails();

        System.out.println();

        Payment payment;

        payment = new UPIPayment();
        payment.pay(2000);

        System.out.println();

        payment = new CardPayment();
        payment.pay(3500);

        System.out.println();

        SecurePayment securePayment = new UPIPayment();
        securePayment.verifyPayment();
        securePayment.pay(1500);

        System.out.println();

        OnlineTransaction transaction = new UPIPayment();

        if (transaction instanceof OnlineTransaction)
        {
            System.out.println("UPI is an online transaction");
        }

        transaction = new CardPayment();

        if (transaction instanceof OnlineTransaction)
        {
            System.out.println("Card is an online transaction");
        }
    }
}