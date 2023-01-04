public class RecNumberPrinter {
    private static String listNumber(int a){
        if(a<=0)
            throw new IllegalArgumentException();
        if(a==1)
            return Integer.toString(a);
        return listNumber(a-1) + " "+ Integer.toString(a);
    }

    public static void main(String[] args){
        try{
            System.out.println(listNumber(Integer.parseInt(args[0])));
        }
        catch(NumberFormatException e){
            System.out.println("Non hai inserito un numero intero");

        }
        catch(IllegalArgumentException e){
                    System.out.println("Numero negativo. errore");
                }
    }
}
