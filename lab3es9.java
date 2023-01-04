/*Scrivere un programma che

riceve in ingresso (su una sola riga) una frase nel formato "Articolo Sostantivo Verbo Aggettivo"
ne stampa a standard output la traduzione nella lingua di Eta Beta (ovvero antepone il carattere 'p' al sostantivo e all'aggettivo),
usando un carattere maiuscolo ad inizio frase.
Ad esempio, se viene inserita la stringa "la vita e` bella" il programma stampera` a standard output la stringa "La pvita e` pbella".  */
import java.util.Scanner;
public class lab3es9 {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserisci frase: ");
        String articolo = c.next();
        String sostantivo = c.next();
        String verbo = c.next();
        String aggettivo = c.next();
        sostantivo = "p" + sostantivo;
        aggettivo = "p" + aggettivo; 
        articolo = articolo.substring(0 ,1).toUpperCase() + articolo.substring(1);
        System.out.println(articolo +" "+ sostantivo +" "+ verbo +" "+ aggettivo);
        c.close();
    }
    
}
