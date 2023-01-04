import java.util.Scanner;

public class es7lab3 {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.print("Inserisci lunghezza in cm del primo cateto:");
        double a = c.nextDouble();
        System.out.print("Inserisci lunghezza in cm del secondo cateto:");
        double b = c.nextDouble();
        double ipotenusa = Math.sqrt(Math.pow(a,2) + Math.pow(b, 2));
        double perimetro = a + b + ipotenusa;
        double area = (a*b)/2;
        double angolo1 = Math.toDegrees(Math.atan(a/b));
        double angolo2 = Math.toDegrees(Math.atan(b/a));
        System.out.printf("%-11s %4.2f cm\n", "Ipotenusa:", ipotenusa);
        System.out.printf("%-11s %4.2f cm\n", "Perimetro:", perimetro);
        System.out.printf("%-11s %4.2f cm^2\n", "Area:", area);
        System.out.printf("%-11s %4.2f °\n", "Angolo1:", angolo1);
        System.out.printf("%-11s %4.2f °\n", "Angolo2:", angolo2);

        c.close();
    }
}
