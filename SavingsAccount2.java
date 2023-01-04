public class SavingsAccount2 extends BankAccount2
{  
    public SavingsAccount2(double rate)
    {
        super();               // costruttore della superclasse
        interestRate = rate;
    }

    public SavingsAccount2(double initialBalance, double rate)
    {
        super(initialBalance); // costruttore della superclasse
        interestRate = rate;
    }

    //accredita gli interessi al termine del mese. Attenzione: usa il metodo
    //deposit della superclasse, altrimenti verrebbe addebitata la penale FEE
    public void addInterest()     //NUOVO METODO
    {
        super.deposit(getBalance() * interestRate / 100);
    }


    // ------- metodi di accesso --------

    public double getInterestRate()
    {   
        return interestRate;
    }


    // ------ metodi di Object sovrascritti ---------
    // ........... toString, equals .................
    public String toString(){
        return super.toString() + "[InterestRate =" + interestRate + "]";
    }

    public boolean equals(Object obj){
        SavingsAccount2 acc2 = (SavingsAccount2) obj;
        return interestRate == acc2.interestRate && super.equals(obj);
    }


    //-------- nuovi campi di esemplare ----------------

    private double interestRate;
}