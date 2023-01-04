
import java.util.*;
import java.io.*;
public class QueueTester {
	public static void main(String[] args) {
		if(args.length!=1) {
			System.out.println("Inserire il nome dl file output in riga di comando.");
			System.exit(1);
		}
		ArrayQueue coda = new ArrayQueue();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			Scanner linescan = new Scanner(sc.nextLine());
			while(linescan.hasNext()) {
				coda.enqueue((Object)(linescan.next()));
			}
		}
		sc.close();
		try(PrintWriter out =new PrintWriter(args[0]+".txt")){
			while(!coda.isEmpty()) {
				out.print((Object)(coda.dequeue() + " "));
			}
		}
		catch(IOException e) {
			System.out.println("Errore.");
			System.exit(1);
		}
		
		
	
	}
}
