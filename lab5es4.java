/*Scrivere un programma che

chiede all'utente di introdurre due stringhe (una per riga), s1 e s2; ciascuna stringa è costituita da tutti i caratteri presenti sulla riga, 
compresi eventuali spazi iniziali, finali e/o intermedi
verifica se la seconda stringa, s2, è una sottostringa di s1, ossia se esiste una coppia di numeri interi, x e y, per cui s1.substring(x, y) 
restituisce una stringa uguale a s2 (al termine della verifica viene visualizzato un messaggio opportuno)
Attenzione:

 Il programma può usare, della classe 
String, 

i soli metodi:
charAt

 e 
length

 (in particolare, quindi, non va utilizzato il metodo 
substring 

appena menzionato).
Verificare che il programma gestisca correttamente la situazione in cui s2 è la stringa vuota (che, in base alla definizione precedente, 
è sottostringa di qualsiasi stringa).*/
import java.util.Scanner;
public class lab5es4 {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserisci la prima stringa : ");
        String s1 = c.nextLine();
        System.out.println("Inserisci la seconda stringa : ");
        String s2 = c.nextLine();                
        boolean uguale = false;

        if(s1.length()<s2.length()){
            System.out.println("La seconda stringa non e' una sottostringa della prima.");
        }else{
            for(int j=0; j<s1.length() && !uguale; j++){
                int a=j;
                uguale = true;
                for(int k=0; k<s2.length() && uguale; k++){
                   if(s1.charAt(j)!=s2.charAt(k)){
                        uguale = false;
                   }else{
                        j++;
                   }
                }
                j=a;
            }
            if(uguale){
                System.out.println("La seconda stringa e' una sottostringa della prima.");
            }else{
                System.out.println("La seconda stringa non e' una sottostringa della prima.");
            }
        }



        c.close();
    }
    
}
