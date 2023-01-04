public class TimeDepositAccount extends SavingsAccount2
{
    private int months;
    public TimeDepositAccount(double rate, int numMonths){
        super(rate);
        months = numMonths;
    }
    public TimeDepositAccount(double initialBalance, double rate, int numMonths){
        super(initialBalance, rate);
        months=numMonths;
    }

    public int trackMonths(){
        if(months>0)
            months--;
        return months;
    }
    public int getMonths(){
        return months;
    }

    public void withdraw(double amount)
    {
        if (months>0){
            super.withdraw(amount + 20);
            return;
        }
        super.withdraw(amount);  
    }
    public String toString(){
        return super.toString() + "[Months= " + months + "]";
    }
    public boolean equals(Object obj){
        TimeDepositAccount acc2 = (TimeDepositAccount) obj;
        return super.equals(obj) && months == acc2.months;
    }
}
