
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class StackTester
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 1) //controllo che da riga di comando sia
        {                     //stata passata esattamente una stringa
            System.out.println("uso: $java StackTester inFile outFile");
            System.exit(1);
        }
      
        // Inserimento elementi da file nella pila
        Scanner in = new Scanner(System.in);
        Stack pila = new ArrayStack();
        while (in.hasNextLine())
        {  Scanner sc = new Scanner(in.nextLine());
            while (sc.hasNext())
            {   String token = sc.next();
                pila.push(token);
            }
        }
        in.close();
      
        // Svuotamento della pila, e scrittura su file
        PrintWriter writer1 = new PrintWriter(args[0]+ ".txt");

        while (!pila.isEmpty())
            writer1.println((String)pila.pop()); 
        writer1.close();
    }
}