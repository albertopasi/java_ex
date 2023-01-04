/*Il Crivello di Eratostene è un noto algoritmo per la ricerca dei numeri primi minori di un certo valore massimo MAX, ed è così specificato:

si predispone un array di MAX valori booleani. Ogni elemento dell'array "rappresenta" il numero intero corrispondente al proprio indice nell'array.
Se e solo se l'elemento è true, allora il numero corrispondente e` stato eliminato dall'insieme dei numeri primi, cioe` non e` un numero primo.
All'inizio si suppone che tutti i numeri siano primi; successivamente, si considera ciascun numero intero maggiore di uno, in ordine crescente, e 
si eliminano tutti i numeri che ne sono multipli, contrassegnandoli opportunamente nell'array.
Al termine, i numeri rimasti (ovvero quelli i cui corrispondenti elementi nell'array valgono ancora true) sono tutti e soli i numeri primi cercati, 
non essendo multipli di alcun numero.
Scrivere un programma che realizza il Crivello di Eratostene per identificare i numeri primi minori di un valore (intero positivo) MAX fornito 
dall'utente attraverso l'ingresso standard. Verificare il corretto funzionamento del programma con:

MAX = 1 (non viene visualizzato nessun numero, perché non esiste nessun numero primo minore di 1)
MAX = 2 (viene visualizzato soltanto il numero 1)
MAX = 3 (vengono visualizzati soltanto i numeri 1 e 2)
MAX = 4 e MAX = 5 (vengono visualizzati soltanto i numeri 1, 2 e 3)
MAX = 6 (vengono visualizzati soltanto i numeri 1, 2, 3 e 5)
*/
import java.util.Scanner;
public class lab6es2 {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserisci un numero: ");
        int max = c.nextInt();
        boolean[] v = new boolean[max];
        for(int j=2; j<max; j++){
            v[j]=true;
        }
        for(int j=2; j<max/2; j++ ){
            for(int k=2; j*k<max; k++){
                v[j*k]=false;
            }
        }
        for(int h=0; h<max; h++){
            if(v[h]){
                System.out.print(h + " ");  
            }
        }
        
        c.close();
    }
}
