import java.util.Scanner;
import java.util.Locale; 

public class a {
    public static void main (String [] args){
        System.out.println("Dimmi quale cazzo e' il numeratore");
        Scanner console = new Scanner(System.in);
        console.useLocale(Locale.US);
        double n = console.nextDouble();
        System.out.println("Dimmi quale cazzo e' il denominatore");
        double d = console.nextDouble();
        double r = n/d;
        System.out.println("Il risulato e':" + r);
        console.close();

    }

}