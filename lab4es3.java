/*Scrivere un programma SimpleTriangoloTester, che riceve da standard input tre numeri interi positivi che rappresentano le lunghezze dei lati di 
un triangolo e che invia a standard output una stringa contenente le seguenti informazioni:

relativamente ai lati: equilatero, isoscele, scaleno
relativamente agli angoli: acutangolo, rettangolo, ottusangolo
Esempi

se vengono inseriti i numeri "3 4 5", il programma visualizzera` la stringa "triangolo scaleno rettangolo".
se vengono inseriti i numeri "5 7 7", il programma visualizzera` la stringa "triangolo isoscele acutangolo".
se vengono inseriti i numeri "5 3 3", il programma visualizzera` la stringa "triangolo isoscele ottusangolo".
se vengono inseriti i numeri "3 3 3", il programma visualizzera` la stringa "triangolo equilatero" (non serve l'informazione relativa agli
angoli perche' i triangoli equilateri sono sempre acutangoli avendo tre angoli uguali pari a pigreco / 3).
se vengono inseriti i numeri "3 4 8", il programma visualizzera` la stringa "non è un triangolo" (non sempre tre lati rappresentano un triangolo). */
import java.util.Scanner;
public class lab4es3 {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserisci i tre lati del rettangolo");
        int lato1 = c.nextInt();
        int lato2 = c.nextInt();
        int lato3 = c.nextInt();
        if(lato1 > lato2){
            int a = lato1;
            lato1 = lato2;
            lato2 = a;
        } 
        if(lato2 > lato3){
            int b = lato2;
            lato2 = lato3;
            lato3 = b;
        } 
        if(lato1 > lato2){
            int d = lato1;
            lato1 = lato2;
            lato2 = d;
        } 
        if(lato3 > (lato1 + lato2)){
            System.out.println("Non esiste un triangolo con i lati di queste lunghezze");
        }else if(lato1 == lato2 && lato2 == lato3){
            System.out.print("Triangolo equilatero ");
        }else {
            if(lato1 != lato2 && lato2 != lato3 && lato1 != lato3){
                System.out.print("Triangolo scaleno ");
            }else if(lato1 == lato2 && lato2 == lato3){
                System.out.print("Triangolo equilatero ");
            }else{
                System.out.print("Triangolo isoscele ");
            }
            if(lato1*lato1 + lato2*lato2 == lato3*lato3){
                System.out.println("rettangolo");
            }else if(lato1*lato1 + lato2*lato2 < lato3*lato3){
                System.out.println("ottusangolo");
            }else{ 
                System.out.println("acutangolo");
            }
        }
    
        c.close();
    }
}
