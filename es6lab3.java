/*Scrivere un programma che

acquisisce da standard input il valore del raggio di un cerchio (numero in virgola mobile)
stampa a stardand output il perimetro e l'area del cerchio corrispondente*/

import java.util.Scanner;

public class es6lab3 {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserisci il raggio del cerchio: ");
        double r = c.nextDouble();
        double area = Math.PI * r * r;
        area = (double) Math.round(area*100) / 100;
        System.out.println("L'area del cerchio e': " + area);
        double perimetro = Math.PI * 2 * r;
        perimetro = (double) Math.round(perimetro*100) / 100;
        System.out.println("Il perimetro del cerchio e': " + perimetro);
        c.close();
    } 
}
