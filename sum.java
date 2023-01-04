import java.util.Scanner; 
public class sum 
{ 
public static void main(String[] args) 
 { 
 Scanner console = new Scanner(System.in); 
 double sum = 0; 
 while (console.hasNextDouble()){ 
 sum = sum + console.nextDouble(); 
 } 
 System.out.println("Somma: " + sum); 
 console.close(); 
} 
} 
