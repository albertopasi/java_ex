public class RecStringReverser {
    private static String reverseString(String a){
        if(a.length()==0)
            throw new IllegalArgumentException();
        if(a.length()==1)
            return a;
        return a.charAt(a.length()-1)+ reverseString(a.substring(0, a.length()-1));
    }
    public static void main(String[] args){
        try{
            System.out.println("La stringa " + args[0] + "invertita diventa: " + reverseString(args[0]));
        }
        catch(IllegalArgumentException e){
            System.out.println("Nessuna stringa inserita");
        }
    
    }
}
