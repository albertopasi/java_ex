public class BankAccount
{ private double balance; 
public BankAccount()
 { balance = 0;
 }
 public BankAccount(double initialBalance)
 {  if(initialBalance<0){
        initialBalance = 0;
        System.out.println("Saldo iniziale impostato a 0");
    }
    balance = initialBalance;
 }
 public void deposit(double amount)
 {  if(amount<0){
        amount = 0;
    }
    balance = balance + amount;
 }
 public void withdraw(double amount)
 {  if(amount<0){
        amount = 0;
        System.out.println("Non puoi prelevare una quantità negativa");

    }else if(amount>balance){
        System.out.println("Saldo non sufficiente, il prelievo equivale all'intero saldo");
        amount = balance;
    }
    balance = balance - amount;
 }
 public double getBalance()
 { return balance;
 } 
public String toString()
 { return "BankAccount: saldo corrente pari a"+balance;
 }
public void addInterest(double rate){
    if(rate<0){
        System.out.println("Tasso di interesse impostato a 0");
    }else{
        balance = balance + balance*rate/100;
    }
}
}
