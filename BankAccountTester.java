/*Progettate una versione modificata della classe BankAccountTester vista a lezione, che

riceva da input standard due numeri in virgola mobile, che specificano rispettivamente il saldo iniziale e il tasso percentuale di interesse
crei un conto bancario accreditando un saldo iniziale ricevuto da standard input come numero in virgola mobile
usi il metodo addInterest per accreditare sul conto bancario gli interessi di due anni, calcolati su un tasso di interesse ricevuto da standard 
    input come numero in virgola mobile
visualizzi il saldo del conto dopo due anni
effettui un prelievo dal conto, pari ad una cifra ricevuta da standard input come numero in virgola mobile 
visualizzi il saldo del conto dopo il prelievo.
Verificare in particolare il funzionamento del programma quando vengono inseriti valori non validi (saldo iniziale negativo, 
    tasso di interesse negativo, prelievo negativo o superiore al saldo).*/
import java.util.Scanner;
public class BankAccountTester {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserisci saldo iniziale: ");
        double saldo = c.nextDouble();        
        BankAccount account = new BankAccount(saldo);
        System.out.println("Inserisci tasso percentuale di interesse: ");
        double tasso = c.nextDouble();
        for(int j=0; j<=1; j++){
            account.addInterest(tasso);
        }
        System.out.println("Il saldo dopo 2 anni e': " + account.getBalance());
        System.out.println("Inserisci quota da prelevare: ");
        double quota= c.nextDouble();
        account.withdraw(quota);
        System.out.println("Il saldo dopo il prelievo e': " + account.getBalance());

        c.close();
    }
}
