
/*Scrivere un programma che

riceve in ingresso una stringa rappresentante un aggettivo qualificativo maschile o femminile (terminante con il carattere 'o' o con il carattere 'a')
stampa a standard output l'aggettivo inserito, con solo il primo carattere maiuscolo
stampa a standard output la forma diminutiva (-ino / -ina) dell'aggettivo inserito
stampa a standard output il grado superlativo assoluto (-issimo / -issima) dell'aggettivo inserito
Ad esempio, se viene inserita la stringa "bello", il programma visualizzera` l'output

Aggettivo inserito:    Bello
Forma diminutiva:      Bellino
Superlativo assoluto:  Bellissimo */
import java.util.Scanner;

public class lab3es10 {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        System.out.println("Inserici aggettivo: ");
        String a = c.next();
        char ultima = a.charAt(a.length() - 1);
        a = a.substring(0, 1).toUpperCase() + a.substring(1, a.length() - 1);
        String diminutivo = a + "in" + ultima;
        String superlativo = a + "issim" + ultima;
        System.out.println("Aggettivo inserito: " + a + ultima);
        System.out.println("Forma diminutiva: " + diminutivo);
        System.out.println("Superlativo assoluto: " + superlativo);

        c.close();
    }
}
