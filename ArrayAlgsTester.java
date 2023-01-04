/*Studiare la classe ArrayAlgs vista a lezione. Testarne i metodi scrivendo una classe di collaudo ArrayAlgsTester che

crea un array di numeri interi casuali, la cui dimensione e intervallo di variabilità è specificata dall'utente
accetta ripetutamente comandi dall'utente, introdotti da tastiera, finché l'utente non introduce il comando di terminazione del programma.
I comandi disponibili sono:

Q	Quit: termina il programma
P	Print: stampa il contenuto dell'array
m	min: calcola il minimo valore contenuto nell'array
M	Max: calcola il massimo valore contenuto nell'array
r i	remove index: rimuove dall'array l'elemento di indice i
R i	Remove-sorted index: rimuove dall'array l'elemento di indice i, mantenendo l'ordine degli altri elementi
I i v	Insert index value: inserisce il valore value nella posizione specificata dall'indice index*/
import java.util.Scanner;
public class ArrayAlgsTester {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserisci lunghezza array: ");
        int lunghezza = c.nextInt();
        System.out.println("Inserisci il massimo valore presente nell'array: ");
        int max = c.nextInt();
        int[] array = ArrayAlgs.randomIntArray(lunghezza, max);
        boolean quit = false;
        
        while(!quit){
            System.out.println("Inserisci comando: ");
            String comando = c.nextLine();
            if(comando.equalsIgnoreCase("q")){
                quit=true;
            }else if(comando.equalsIgnoreCase("p")){
                System.out.println(ArrayAlgs.printArray(array, lunghezza));
            }else if(comando.equals("m")){
                System.out.println(ArrayAlgs.findMin(array, lunghezza));
            }else if(comando.equals("M")){
                System.out.println(ArrayAlgs.findMax(array, lunghezza));
            }else if(comando.equals("r i")){
                System.out.println("Inserisci l'indice del valore da togliere: ");
                int index= c.nextInt();
                ArrayAlgs.remove(array, lunghezza, index);
            }else if(comando.equals("R i")){
                System.out.println("Inserisci l'indice del valore da togliere: ");
                int index= c.nextInt();
                ArrayAlgs.removeSorted(array, lunghezza, index);
            }else if(comando.equals("I i v")){
                System.out.println("Inserisci l'indice del valore da inserire: ");
                int index= c.nextInt();
                System.out.println("Inserisci il valore da inserire: ");
                int valore= c.nextInt();
                array = ArrayAlgs.insert(array, lunghezza, index, valore);
                lunghezza++;
            }
        }
        c.close();
    }
}
