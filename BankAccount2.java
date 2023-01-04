public class BankAccount2
{
    private double balance;

    public BankAccount2()
    {
        balance = 0;
    }

    public BankAccount2(double initialBalance)
    {   
        deposit(initialBalance);
    }

    public void deposit(double amount)
    {
        if (amount <= 0)
            throw new IllegalArgumentException();
        balance = balance + amount;
    }

    public void withdraw(double amount)
    {
        if (amount > balance || amount <= 0)
            throw new IllegalArgumentException();
        balance = balance - amount;
    }

    public void transfer(double amount, BankAccount2 other)
    { 
        withdraw(amount);
        other.deposit(amount);
    }


    // ------- metodi di accesso --------

    public double getBalance()
    {   
        return balance;
    }


    // ------ metodi di Object da sovrascrivere ---------
    // ......... toString e equals ......................
    public String toString(){
        return getClass().getName() +"[Balance = " + balance + "]";
    }

    public boolean equals(Object obj){
        BankAccount2 obj2 = (BankAccount2) obj;
        return balance == obj2.balance;
    }

}