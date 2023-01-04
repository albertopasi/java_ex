public class BankAccountTester2 
{ public static void main(String[] args) 
    { BankAccount account = new BankAccount(); 
        account.deposit(10000); 
        final double RATE = 5; 
        // calcola gli interessi dopo il primo anno
        double interest = account.getBalance() * RATE / 100; 
        // somma gli interessi dopo il primo anno
        account.deposit(interest); 
        System.out.println("Saldo dopo un anno: "  + account.getBalance() + " euro");
        // calcola gli interessi dopo il secondo anno 
        interest = account.getBalance() * RATE / 100; 
        // somma gli interessi dopo il secondo anno 
        account.deposit(interest); 
        System.out.println("Saldo dopo due anni: " 
        + account.getBalance() + " euro"); 
    } 
} 