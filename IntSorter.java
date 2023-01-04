import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class IntSorter {
    public static void main(String[] args){
        Scanner c=new Scanner(System.in);
        SortedArray array = new SortedArray();
        int n = Integer.parseInt(args[0]);
        for(int j=0; j<n; j++){
            array.add((int) (Math.random()*n));
        }
        System.out.println(array.toString());
        System.out.println("La media dei valorei e': " + array.avg());
        while(true){
            System.out.print("Inserire numero da cercare compreso tra 1 ed N. Inserire q per terminare. --> ");
            String a = c.next();
            if(a.equalsIgnoreCase("q")){
                break;
            }else if(Integer.parseInt(a)<1 || Integer.parseInt(a)>n){
                System.out.println("Valore non compreso nell'intervallo.");
            }else if(Integer.parseInt(a)>=1 && Integer.parseInt(a)<=n){
                if(array.search(Integer.parseInt(a)) == -1){
                    System.out.println("Valore non trovato");
                }else{
                    System.out.println("Valore trovato all'indice " + array.search(Integer.parseInt(a)));
                }
            }
        }
        c.close();
        try(PrintWriter out = new PrintWriter(args[1]+".txt")){
            for(int j=0; j<n; j++){
                out.print(array.removeMax() + "  ");
                if(j%10==9){
                    out.print("\n");
                }
            }
            
            out.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Errore");
        }


    }
}
