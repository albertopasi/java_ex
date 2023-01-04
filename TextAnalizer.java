import java.util.Scanner;
public class TextAnalizer {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        TextContainer z = new TextContainer();
        do{
            String a = c.nextLine();
            if(a.equals("")){
                break;
            }
            z.add(a);
        }while(true);

        TextContainer x;
        x = z.splitWords();
        x = x.onlyLetters();
        x = x.toLowerCase();

        System.out.println(z.toString());
        System.out.println("Numero parole: "+ x.count());
        System.out.println("Prima parola in ordine lessicografico: " + x.min());
        System.out.println("Ultima parola in ordine lessicografico: " + x.max());
        System.out.println("5 parole piu' frequenti: ");
        for(int i =0; i<5; i++){
            String parola= x.maxFrequency();
            System.out.println(parola);
            x.remove(parola);
        }

        c.close();
    }
}
