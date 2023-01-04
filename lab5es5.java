/*Scrivere un programma che

chiede all'utente di introdurre due stringhe (una per riga), s1 e s2; ciascuna stringa è costituita da tutti i caratteri presenti 
sulla riga, compresi eventuali spazi iniziali, finali e/o intermedi
verifica se la seconda stringa s2 è una sottosequenza di s1 (al termine della verifica viene visualizzato un messaggio opportuno).
Il programma può usare, della classe String, i soli metodi charAt e length. 
Una stringa s2 è una sottosequenza di un'altra stringa s1 se e solo se tutti i caratteri di s2 sono presenti in s1 nello stesso 
ordine (anche se in posizioni diverse). Ad esempio, gatto è una sottosequenza di gratto e xyz è una sottosequenza di 2xpppyqz ma non di yxz.
Ovviamente, una sottostringa e` anche una sottosequenza, ma non viceversa.*/
import java.util.Scanner;
public class lab5es5 {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserisci la prima stringa : ");
        String s1 = c.nextLine();
        System.out.println("Inserisci la seconda stringa : ");
        String s2 = c.nextLine(); 
        boolean trovato = true;
        int j=0;
        if(s1.length()<s2.length()){
            System.out.println("La seconda stringa non e' una sottosequenza della prima.");
        }else{
            for(int k=0; k<s2.length() && trovato; k++){
                trovato = false;
                for( ; j<s1.length() && !trovato; j++){
                    if(s1.charAt(j)==s2.charAt(k)){
                        trovato = true;
                    }
                }
            }
            if(trovato){
              System.out.println("La seconda stringa e' una sottosequenza della prima.");
            }else{
              System.out.println("La seconda stringa non e' una sottosequenza della prima.");
            }
        }
        



        c.close();
    }
}
