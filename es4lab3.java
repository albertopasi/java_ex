import java.util.Scanner;
import java.util.Locale;

public class es4lab3{
    public static void main (String[] args){
        Scanner console = new Scanner(System.in);
        console.useLocale(Locale.US);
        System.out.println("Inserisci tre numeri: ");
        double a, b, c;
        a = console.nextDouble();
        b = console.nextDouble();
        c = console.nextDouble();
        System.out.println(a + " + " + b + " + " + c + " = " + (a+b+c));
        console.close();
    }
}