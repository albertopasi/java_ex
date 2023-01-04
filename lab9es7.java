import java.util.*;
public class lab9es7
{   public static void main(String[] args){
        if (args.length != 1 || (!args[0].equals("a") && !args[0].equals("b")))
        {   System.out.println("Uso: $java StackSorter < arg >");
            System.out.println("Se arg = \"a\" si usa soluzione a (2 pile)");
            System.out.println("Se arg = \"b\" si usa soluzione b (1 pila)");
            System.exit(1);
        }
        System.out.println("Inserire numeri in virgola mobile, digitare \"stop\" per terminare l'inserimento: ");
        Scanner c = new Scanner(System.in);
        boolean fine=false;
        Stack s = new ArrayStack();
        while(!fine){
                String a = c.nextLine();
                Scanner lineScan= new Scanner(a);
                while(lineScan.hasNext()){
                    String num=lineScan.next();
                    if(num.equals("stop")){
                        fine=true;
                    }else{
                            s.push(Double.parseDouble(num));
                    }
                }
        }
        System.out.println(s.toString());
        if(args[0].equals("a")){
            System.out.println("*** Pila con elementi ordinati tramite metodo a***");
            OrdinaStackA(s);
        }else{
            System.out.println("*** Pila con elementi ordinati tramite metodo b***");
            OrdinaStackB(s);
        }

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }


        
    }

    public static void OrdinaStackA(Stack s) {
        Stack temp1 = new ArrayStack();
        while(!s.isEmpty()){
            temp1.push(s.pop());
        }
        while(!temp1.isEmpty()){
            Stack temp2 = new ArrayStack();
            Comparable max = (Comparable) temp1.pop();
            while(!temp1.isEmpty()){
                Comparable c = (Comparable) temp1.pop();
                if(c.compareTo(max)<0){
                    temp2.push(c);
                }else{
                    temp2.push(max);
                    max=c;
                }
            }
            s.push(max);
            temp1=temp2;
        }
    }

    public static void OrdinaStackB(Stack s){
        Stack temp1 = new ArrayStack();
        int count=0;
        while(!s.isEmpty()){
            temp1.push(s.pop());
            count++;
        }
        while(count>0){
            Comparable max = (Comparable) temp1.pop();
            count--;
            for(int i=0; i<count; i++){
                Comparable c = (Comparable) temp1.pop();
                if(c.compareTo(max)<0){
                    s.push(c);
                }else{
                    s.push(max);
                    max=c;
                }
            }
            for(int i =0; i<count; i++){
                temp1.push(s.pop());
            }
            s.push(max);
        }
    }
}


