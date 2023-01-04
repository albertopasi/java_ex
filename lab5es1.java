/*Argomento: gestione dell'input tramite "ciclo e mezzo"

Scrivere un programma che legga una sequenza di valori in virgola mobile inseriti dall'utente: il numero di valori non è predeterminato, 
dopo l'introduzione di ciascun valore l'utente deve premere il tasto "Invio" e la sequenza di valori termina non appena l'utente introduce 
una sequenza predeterminata di caratteri che non rappresenta un numero in virgola mobile.
Dopo aver letto tutti i valori inseriti dall'utente, il programma ne deve visualizzare il valore medio e la deviazione standard.

Suggerimento: Il valore medio di una sequenza di valori è (ovviamente) uguale alla somma di tutti i valori divisa per il numero di valori. 
La deviazione standard D si calcola con la formula seguente: 

  D = Math.sqrt((A - B*B/n)/(n-1)) 

dove n è il numero di valori, B è la somma di tutti i valori e A è la somma dei quadrati di tutti i valori. La formula e` valida soltanto per 
n > 1; per n = 1 la deviazione standard vale 0, per definizione.
Gestire correttamente anche il caso in cui il numero di valori è zero: in tal caso il valore medio dei valori si assume essere convenzionalmente 
uguale a zero, così come la deviazione standard.
Attenzione: Porre particolare attenzione all'impossibilità (con gli strumenti di Java che si conoscono) di memorizzare tutti i singoli valori 
introdotti dall'utente.*/
import java.util.Scanner;
public class lab5es1 {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserire una serie di numeri in virgola mobile, premere invio dopo ogni inserimento. Per terminare l'inserimento digitare \"s\"");
        double somma=0;
        double quadrati=0;
        int quanti=0;
        boolean verifica=true;
        String stop="s";
        String valore;
        while(verifica){
            valore=c.next();
            if(valore.equals(stop)){
                verifica=false;
            }else{
                double num= Double.parseDouble(valore);
                somma += num;
                quadrati += (num*num);
                quanti++;
            }
        }
        double dev= Math.sqrt((quadrati - somma*somma/quanti)/(quanti-1));
        System.out.println("Il valore medio e': " + somma/quanti);
        System.out.println("La deviazione standard e': " + dev);

        c.close();
    }
}
//5.3333 
//1.527    7 5 4