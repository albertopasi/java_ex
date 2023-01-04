//Alberto Pasinato il tuo alunno prefe
import java.util.*;
public class Pasinato2032660Ric {
    public static String VocaliRic(String a){
        if(a.length()==0) return "";
        char v= Character.toUpperCase(a.charAt(0));
        if(v=='A' || v=='E' || v=='I' || v=='O' || v=='U'){
            return  a.charAt(0) + VocaliRic(a.substring(1));
        }
        return VocaliRic(a.substring(1));
    }

    public static String VocaliContrarioRic(String a){
        if(a.length()==0) return "";
        char v= Character.toUpperCase(a.charAt(a.length()-1));
        if(v=='A' || v=='E' || v=='I' || v=='O' || v=='U'){
            return  a.charAt(a.length()-1) + VocaliContrarioRic(a.substring(0, a.length()-1 ));
        }
        return VocaliContrarioRic(a.substring(0, a.length()-1));
    }

    public static void main(String[] args){
        Scanner c=new Scanner(System.in);
        System.out.println("Inserire una stringa: ");
        String a = c.nextLine();
        System.out.println("Digitare \"a\" per visualizzare le vocali in ordine, \"b\" per visualizzarle al contrario: ");
        String comando = c.next();
        if(comando.equals("a")){
            System.out.println(VocaliRic(a));
        }else{
            System.out.println(VocaliContrarioRic(a));
        }
        
    }
}
