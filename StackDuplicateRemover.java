import java.util.*;
public class StackDuplicateRemover {
    public static void  removeDuplicates(Stack a){
        if(a.isEmpty()) return;
        Stack temp=new ArrayStack();
        Object obj=new Object();
        int count=0;
        Object verifica=new Object();
        while(!a.isEmpty()){
            count++;
            for(int j=0; j<count; j++){
                obj=a.pop();
                temp.push(obj);
            }
            if(a.isEmpty()) {
                while(!temp.isEmpty()){
                    a.push(temp.pop());
                }
                return;
            }
            while(!a.isEmpty()){
                verifica=a.pop();
                if(!verifica.equals(obj)){
                    temp.push(verifica);
                }
            }
            while(!temp.isEmpty()){
                a.push(temp.pop());
            }
        }
    }

    public static void main(String[] args){
        Stack pila=new ArrayStack();
        Scanner c=new Scanner(System.in);
        String input="";
        System.out.println("Inserire numeri interi. Digitare \"stop\" per terminare l'inserimento.");
        while(true){
            try{
                input=c.next();
                if(input.equals("stop")){
                    System.out.println("\n Fine inserimento.");
                    break;
                }
                pila.push(Integer.parseInt(input));
            }
            catch(NumberFormatException e){
                System.out.println("Errore: la stringa inserita non e' un numero intero");
                System.exit(1);
            }
        }
        c.close();
        removeDuplicates(pila);
        System.out.println("********Contenuto della pila senza duplicati*********");
        while(!pila.isEmpty()){
            System.out.print(pila.pop() + " ");
        }
    }
}
