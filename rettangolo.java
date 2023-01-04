import java.awt.Rectangle; 
import java.util.Scanner;

public class rettangolo { 
 public static void main(String[] args) 
 {
    System.out.print("Inserire coordinata x dello spigolo in alto a sinistra:");
    Scanner console = new Scanner(System.in); 
    int x = console.nextInt();
    System.out.print("Inserire coordinata y dello spigolo in alto a sinistra:");
    int y = console.nextInt();
    System.out.print("Inserire l'altezza del rettangolo:");
    int h = console.nextInt();
    System.out.print("Inserire la base del rettangolo");
    int l = console.nextInt();
    console.close();
    Rectangle box = new Rectangle(x, y, l, h);
    double a = box.getWidth()*box.getHeight();
    System.out.println("L'area del rettangolo e': " + a );

 }
}