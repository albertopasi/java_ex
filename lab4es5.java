/*Scrivere un programma che verifica se una stringa, introdotta dall'utente tramite lo standard input (un'intera riga), e` una palindrome. Suggerimento:

 Una stringa è una palindrome se è composta da una sequenza di caratteri (anche non alfabetici) che possa essere letta allo stesso identico modo anche al contrario (es. "radar", "anna", "inni", "xyz%u%zyx").
Il programma deve eseguire il minimo numero di confronti necessari per determinare se la stringa è una palindrome. 
Verificare il corretto funzionamento del programma con:

una stringa palindroma di lunghezza pari
una stringa palindroma di lunghezza dispari
una stringa non palindroma di lunghezza pari
una stringa non palindroma di lunghezza dispari
una stringa di lunghezza unitaria (che è ovviamente palindroma)
una stringa di lunghezza zero (che è ragionevole definire palindroma) */
import java.util.Scanner;
public class lab4es5 {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserisci parola: ");
        String a = c.nextLine();
        boolean palindromo = true;
        for(int j=0 ; j < a.length()/2 && palindromo ; j++){
            if(a.charAt(j) != a.charAt(a.length()-1-j)){
                palindromo = false;
            }
        }
        if(palindromo){
            System.out.println("La parola e' palindroma");
        }else{
            System.out.println("La parola non e' palindroma");
        }

        c.close();
    }
}
