/*Scrivere un programma che

acquisisce da standard input il valore in gradi di un angolo (un numero in virgola mobile)
stampa a stardand output i seguenti numeri, tutti approssimati a tre cifre decimali
il valore dell'angolo, espresso in radianti, normalizzato nell'intervallo (-2π, 2π) e visualizzato come multiplo di π
il valore del seno dell'angolo
il valore del coseno dell'angolo
il valore della tangente dell'angolo
Esempio: se si introduce il numero 405.0 (che quindi corrisponde a 45°), l'esecuzione produce le seguenti stampe:

Angolo = 0.250*π rad
sin(0.250*π) = 0.707
cos(0.250*π) = 0.707
tan(0.250*π) = 1.000*/

import java.util.Scanner;
public class lab3es8 {
    public static void main (String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserisci l'angolo in gradi: ");
        double a = c.nextDouble();
        double rad = Math.toRadians(a);
        double r = (double) Math.round((rad/Math.PI)*1000)/1000;
        System.out.println("Angolo = " + r + "*pi rad");
        double sin = Math.sin(rad);
        System.out.println("sin("+r+"*pi) = " + (double) Math.round(sin*1000)/1000);
        double cos = Math.cos(rad);
        System.out.println("cos("+r+"*pi) = " + (double) Math.round(cos*1000)/1000);
        double tan = Math.tan(rad);
        System.out.println("tan("+r+"*pi) = " + (double) Math.round(tan*1000)/1000);
        c.close();
    }
    
}
