package com.driver;


import java.util.HashSet;public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    public String   getName() {
        return name;
    }
    public double   getBalance() {
        return balance;
    }
    public double   getMinBalance() {
        return minBalance;
    }

    public BankAccount(String name, double balance, double minBalance)
    {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
//Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(sum>9*digits)
            throw new Exception( "Account Number can not be generated");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<digits;i++)
        {
            if(sum>=9)
            {
                stringBuilder.append('9');
                sum-=9;
            }
            else {
                stringBuilder.append((char)('0'+sum));
                sum=0;
            }
        }
        return stringBuilder.toString();
    }

    public void deposit(double amount)
    {
        this.balance+=amount;
        //add amount to balance

    }


    public void withdraw(double amount) throws Exception
    {
        if(this.balance-amount<this.minBalance)
        {
            throw new Exception("Insufficient Balance");
        }
        else
        {
            this.balance -= amount;
        }


        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

    }


}